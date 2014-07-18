package com.fourtwosix.codahale.metrics;

import com.fourtwosix.codahale.metrics.thrift.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;

public class MetricsModule {
	private static final TSerializer serializer = new TSerializer();
	private final boolean showSamples;
	private final TimeUnit rateUnit;
	private final TimeUnit durationUnit;

	private <T> Gauge convert(com.codahale.metrics.Gauge<T> gauge) throws IOException {
		Gauge forReturn = new Gauge();
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutput out = null;
			try {
			  out = new ObjectOutputStream(bos);   
			  out.writeObject(gauge);
			  byte[] value = bos.toByteArray();
			  forReturn.setValue(ByteBuffer.wrap(value));
			} finally {
			  try {
			    if (out != null) {
			      out.close();
			    }
			  } catch (IOException ex) {
			    // ignore close exception
			  }
			  try {
			    bos.close();
			  } catch (IOException ex) {
			    // ignore close exception
			  }
			}			
		} catch (RuntimeException e) {
			forReturn.setError(e.toString());
		}
		return forReturn;
	}
	
	public <T> byte[] serialize(com.codahale.metrics.Gauge<T> gauge) throws TException, IOException {
		return serializer.serialize(convert(gauge));
	}

	private Counter convert(com.codahale.metrics.Counter counter) throws TException {
		Counter forReturn = new Counter();
		forReturn.setCount(counter.getCount());
		return forReturn;
	}

	public byte[] serialize(com.codahale.metrics.Counter counter) throws TException {
		return serializer.serialize(convert(counter));
	}

	private HistogramSnapshot convert(com.codahale.metrics.Histogram histogram) {
		HistogramSnapshot forReturn = new HistogramSnapshot();
		final com.codahale.metrics.Snapshot snapshot = histogram.getSnapshot();
		forReturn.setCount(histogram.getCount());
		forReturn.setMax(snapshot.getMax());
		forReturn.setMean(snapshot.getMean());
		forReturn.setMin(snapshot.getMin());
		forReturn.setP50(snapshot.getMedian());
		forReturn.setP75(snapshot.get75thPercentile());
		forReturn.setP95(snapshot.get95thPercentile());
		forReturn.setP98(snapshot.get98thPercentile());
		forReturn.setP99(snapshot.get99thPercentile());
		forReturn.setP999(snapshot.get999thPercentile());
		if (showSamples) {
			long[] snapshotValues = snapshot.getValues();
			List<Long> values = new ArrayList<Long>(snapshotValues.length);
			for (long value: snapshotValues) {
				values.add(value);
			}
			forReturn.setValues(values);
		}
		forReturn.setStdDev(snapshot.getStdDev());
		return forReturn;
	}

	public byte[] serialize(com.codahale.metrics.Histogram histogram) throws TException {
		return serializer.serialize(convert(histogram));
	}

	private Meter convert(com.codahale.metrics.Meter meter) {
		double rateFactor = rateUnit.toSeconds(1);
		Meter forReturn = new Meter();
		forReturn.setCount(meter.getCount());
		forReturn.setM15Rate(meter.getFifteenMinuteRate() * rateFactor);
		forReturn.setM1Rate(meter.getOneMinuteRate() * rateFactor);
		forReturn.setM5Rate(meter.getFiveMinuteRate() * rateFactor);
		forReturn.setMeanRate(meter.getMeanRate() * rateFactor);
		forReturn.setUnits(calculateRateUnit(rateUnit, "events"));
		return forReturn;
	}

	public byte[] serialize(com.codahale.metrics.Meter meter) throws TException {
		return serializer.serialize(convert(meter));
	}

	private TimerSnapshot convert(com.codahale.metrics.Timer timer) {
		final double rateFactor = rateUnit.toSeconds(1);
		final double durationFactor = 1.0 / durationUnit.toNanos(1);
		TimerSnapshot forReturn = new TimerSnapshot();
		final com.codahale.metrics.Snapshot snapshot = timer.getSnapshot();
		forReturn.setCount(timer.getCount());
		forReturn.setMax(snapshot.getMax() * durationFactor);
		forReturn.setMean(snapshot.getMean() * durationFactor);
		forReturn.setMin(snapshot.getMin() * durationFactor);
		forReturn.setP50(snapshot.getMedian() * durationFactor);
		forReturn.setP75(snapshot.get75thPercentile() * durationFactor);
		forReturn.setP95(snapshot.get95thPercentile() * durationFactor);
		forReturn.setP98(snapshot.get98thPercentile() * durationFactor);
		forReturn.setP99(snapshot.get99thPercentile() * durationFactor);
		forReturn.setP999(snapshot.get999thPercentile() * durationFactor);

		if (showSamples) {
			final long[] values = snapshot.getValues();
			List<Double> scaledValues = new ArrayList<Double>(values.length);
			for (long value : values) {
				scaledValues.add(value * durationFactor);
			}
			forReturn.setValues(scaledValues);
		}

		forReturn.setStdDev(snapshot.getStdDev() * durationFactor);
		forReturn.setM15Rate(timer.getFifteenMinuteRate() * rateFactor);
		forReturn.setM1Rate(timer.getOneMinuteRate() * rateFactor);
		forReturn.setM5Rate(timer.getFiveMinuteRate() * rateFactor);
		forReturn.setMeanRate(timer.getMeanRate() * rateFactor);
		forReturn.setDurationUnits(durationUnit.toString().toLowerCase(Locale.US));
		forReturn.setRateUnits(calculateRateUnit(rateUnit, "calls"));
		
		return forReturn;
	}

	public byte[] serialize(com.codahale.metrics.Timer timer) throws TException {
		return serializer.serialize(convert(timer));
	}

	public byte[] serialize(com.codahale.metrics.MetricRegistry registry) throws TException, IOException {
		MetricRegistry forReturn = new MetricRegistry();
		Map<String,Gauge> gaugeMap = new HashMap<String,Gauge>();
		for (Entry<String,com.codahale.metrics.Gauge> entry : registry.getGauges().entrySet()) {
			gaugeMap.put(entry.getKey(), convert(entry.getValue()));
		}
		forReturn.setGauges(gaugeMap);
		Map<String,Counter> counterMap = new HashMap<String,Counter>();
		for (Entry<String,com.codahale.metrics.Counter> entry : registry.getCounters().entrySet()) {
			counterMap.put(entry.getKey(), convert(entry.getValue()));
		}
		forReturn.setCounters(counterMap);
		Map<String,HistogramSnapshot> histogramMap = new HashMap<String,HistogramSnapshot>();
		for (Entry<String,com.codahale.metrics.Histogram> entry : registry.getHistograms().entrySet()) {
			histogramMap.put(entry.getKey(), convert(entry.getValue()));
		}
		forReturn.setHistograms(histogramMap);
		Map<String,Meter> meterMap = new HashMap<String,Meter>();
		for (Entry<String,com.codahale.metrics.Meter> entry : registry.getMeters().entrySet()) {
			meterMap.put(entry.getKey(), convert(entry.getValue()));
		}
		forReturn.setMeters(meterMap);
		Map<String,TimerSnapshot> timerMap = new HashMap<String,TimerSnapshot>();
		for (Entry<String,com.codahale.metrics.Timer> entry : registry.getTimers().entrySet()) {
			timerMap.put(entry.getKey(), convert(entry.getValue()));
		}
		forReturn.setTimers(timerMap);
		return serializer.serialize(forReturn);
	}

	public MetricsModule(TimeUnit rateUnit, TimeUnit durationUnit, boolean showSamples) {
		this.rateUnit = rateUnit;
		this.durationUnit = durationUnit;
		this.showSamples = showSamples;
	}

	private static String calculateRateUnit(TimeUnit unit, String name) {
		final String s = unit.toString().toLowerCase(Locale.US);
		return name + '/' + s.substring(0, s.length() - 1);
	}
}

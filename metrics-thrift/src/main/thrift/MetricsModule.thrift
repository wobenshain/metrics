namespace java com.fourtwosix.codahale.metrics.thrift

struct Gauge {
  1: optional binary value;
  2: optional string error;
}

struct Counter {
  1: required i64 count;
}

struct HistogramSnapshot {
  1: required i64 count;
  2: required i64 max;
  3: required double mean;
  4: required i64 min;
  5: required double p50;
  6: required double p75;
  7: required double p95;
  8: required double p98;
  9: required double p99;
  10: required double p999;
  11: optional list<i64> values;
  12: required double StdDev;
}

struct Meter {
  1: required i64 count;
  2: required double m15Rate;
  3: required double m1Rate;
  4: required double m5Rate;
  5: required double meanRate;
  6: required string units;
}

struct TimerSnapshot {
  1: required i64 count;
  2: required double max;
  3: required double mean;
  4: required double min;
  5: required double p50;
  6: required double p75;
  7: required double p95;
  8: required double p98;
  9: required double p99;
  10: required double p999;
  11: optional list<double> values;
  12: required double StdDev;
  13: required double m15Rate;
  14: required double m1Rate;
  15: required double m5Rate;
  16: required double meanRate;
  17: required string durationUnits;
  18: required string rateUnits;
}

struct MetricRegistry {
  1: required map<string,Gauge> gauges;
  2: required map<string,Counter> counters;
  3: required map<string,HistogramSnapshot> histograms;
  4: required map<string,Meter> meters;
  5: required map<string,TimerSnapshot> timers;
}


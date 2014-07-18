package com.fourtwosix.codahale.metrics;

import com.codahale.metrics.health.HealthCheck;
import com.fourtwosix.codahale.metrics.thrift.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;

public class HealthCheckModule {
	private static TSerializer serializer = new TSerializer();
    public byte[] serialize(HealthCheck.Result result) throws TException {
    	HealthCheckResult forReturn = new HealthCheckResult();
    	forReturn.setHealthy(result.isHealthy());

        final String message = result.getMessage();
        if (message != null) {
        	forReturn.setMessage(message);
        }

        List<HealthCheckResultError> errorStack = serializeThrowable(result.getError());
        forReturn.setError(errorStack);
    	return serializer.serialize(forReturn);
    }

    private List<HealthCheckResultError> serializeThrowable(Throwable error) {
        if (error != null) {
        	HealthCheckResultError thriftError = new HealthCheckResultError();
        	thriftError.setMessage(error.getMessage());
        	List<String> stackTrace = new ArrayList<String>();
            for (StackTraceElement element : error.getStackTrace()) {
                stackTrace.add(element.toString());
            }
            thriftError.setStack(stackTrace);
            List<HealthCheckResultError> errorStack = serializeThrowable(error.getCause());
            errorStack.add(0,thriftError);
            return errorStack;
        } else {
        	return new ArrayList<HealthCheckResultError>();
        }
    }
}

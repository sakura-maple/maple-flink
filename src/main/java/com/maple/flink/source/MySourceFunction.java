package com.maple.flink.source;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

/**
 * sourceFunction 非并行的
 * RichSourceFunction  ParallelSourceFunction并行的
 */
public class MySourceFunction implements SourceFunction<String> {

    @Override
    public void run(SourceContext<String> sourceContext) throws Exception {

    }

    @Override
    public void cancel() {

    }
}

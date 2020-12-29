package com.maple.flink.source;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;

public class MyRichSourceFunction extends RichSourceFunction<String> {

    public void open(Configuration parameters) throws Exception {

    }

    @Override
    public void run(SourceContext<String> sourceContext) throws Exception {

    }

    @Override
    public void cancel() {

    }
}



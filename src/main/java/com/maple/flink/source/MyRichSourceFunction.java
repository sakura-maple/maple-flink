package com.maple.flink.source;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;

public class MyRichSourceFunction extends RichSourceFunction<String> {

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);

    }

    @Override
    public void run(SourceContext<String> sourceContext) throws Exception {
        int i=0;
        while (i<10){
            sourceContext.collect("100"+i);
            i++;
        }


    }

    @Override
    public void cancel() {

    }
}



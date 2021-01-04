package com.maple.flink.sink;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

public class MySinkFunction extends RichSinkFunction<Tuple2<String, Long>> {

    @Override
    public void open(Configuration parameters) throws Exception{
        super.open(parameters);
    }


    @Override
    public void close() throws Exception {
        super.close();
    }

    @Override
    public void invoke(Tuple2<String, Long> value, Context context) throws Exception {
        System.out.println(value.f0+"--->"+value.f1.toString());
    }
}

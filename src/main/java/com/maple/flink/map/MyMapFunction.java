package com.maple.flink.map;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;

public class MyMapFunction extends RichMapFunction<String, Tuple2<String,Long>> {
    @Override
    public Tuple2<String, Long> map(String value) throws Exception {
        return null;
    }
}

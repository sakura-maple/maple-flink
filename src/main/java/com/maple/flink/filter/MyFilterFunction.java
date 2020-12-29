package com.maple.flink.filter;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.java.tuple.Tuple2;

public class MyFilterFunction implements FilterFunction<Tuple2<String, Long>> {
    @Override
    public boolean filter(Tuple2<String, Long> stringLongTuple2) throws Exception {
        return !stringLongTuple2.f0.equals("hello");
    }
}

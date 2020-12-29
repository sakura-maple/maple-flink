package com.maple.flink.keyby;

import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;

public class MyKeyByFunction implements KeySelector<Tuple2<String, Long>, String>  {

    @Override
    public String getKey(Tuple2<String, Long> value) throws Exception {
        return value.f0;
    }
}

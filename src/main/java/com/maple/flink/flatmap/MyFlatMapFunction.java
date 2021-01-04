package com.maple.flink.flatmap;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class MyFlatMapFunction implements FlatMapFunction<String,Tuple2<String,Long>> {
    /**
     * Collector 收集器 想要输出的结果都放到Collector
     * out 输出
     * @param string
     * @param out
     */
    @Override
    public void flatMap(String string, Collector<Tuple2<String,Long>> out) {
        //按空格分词 包装成二元组
        String[] strings = string.split(" ");
        System.out.println(Thread.currentThread().getName());
        for (String word : strings) {
            Tuple2<String, Long> stringLongTuple2 = new Tuple2<>(word, 1L);
            out.collect(new Tuple2<>(word, 1L));
        }
    }
}

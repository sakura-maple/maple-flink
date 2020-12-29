package com.maple.flink.datastream;

import com.maple.flink.filter.MyFilterFunction;
import com.maple.flink.flatmap.MyFlatMapFunction;
import com.maple.flink.keyby.MyKeyByFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class DataStreamSocket {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> dataStreamSource = executionEnvironment.socketTextStream("localhost", 9999);
        /**
         * 3. 指定数据转换
         */
        DataStream<Tuple2<String, Long>> sum = dataStreamSource
                .flatMap(new MyFlatMapFunction())
                .filter(new MyFilterFunction())
                .keyBy(new MyKeyByFunction())
                .sum(1);

        /**
         * 4.标准输出
         */
        sum.print();
        /**
         * 5.开始执行
         */

        executionEnvironment.execute("DataStreamSocket");
    }
}

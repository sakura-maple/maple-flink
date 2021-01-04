package com.maple.flink.datastream;


import com.maple.flink.flatmap.MyFlatMapFunction;
import com.maple.flink.keyby.MyKeyByFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;


public class DataStreamDemo {
    public static void main(String[] args) throws Exception {
        /**
         * 1.StreamExecutionEnvironment是所有Flink程序的基础
         * 通过调用静态方法getExecutionEnvironment() ，它将创建一个本地环境，该环境将在本地计算机上执行您的程序
         */
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        /**
         * 默认并行度按照当前电脑核心数   env.setParallelism(8);
         */
        env.setParallelism(8);
        /**
         * 2.加载数据源 关于官方数据源数据源连接器https://ci.apache.org/projects/flink/flink-docs-release-1.12/dev/connectors/
         */
        String inputPath = "C:\\Users\\43530\\IdeaProjects\\maple-flink\\src\\main\\java\\com\\maple\\resource\\readme.txt";
        DataStreamSource<String> stringDataStreamSource = env.readTextFile(inputPath);
//        env.addSource()

        /**
         * 3. 指定数据转换
         */
        DataStream<Tuple2<String, Long>> sum = stringDataStreamSource
                .flatMap(new MyFlatMapFunction())
//                .filter(new MyFilterFunction())
                .keyBy(new MyKeyByFunction())
                .sum(1);

        /**
         * 4.标准输出
         */
        sum.print();
        /**
         * 5.开始执行
         */
        env.execute("StreamFlinkDemo");

    }
}

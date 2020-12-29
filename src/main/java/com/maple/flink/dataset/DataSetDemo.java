package com.maple.flink.dataset;

import com.maple.flink.flatmap.MyFlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;

public class DataSetDemo {
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment executionEnvironment = ExecutionEnvironment.getExecutionEnvironment();
        //文件路径
        String inputPath = "C:\\Users\\43530\\IdeaProjects\\maple-flink\\src\\main\\java\\com\\maple\\resource\\readme.txt";
        //从文件读数据 获取数据源
        DataSet<String> stringDataSource = executionEnvironment.readTextFile(inputPath);
        stringDataSource.print();
        DataSet<Tuple2<String, Long>> sum = stringDataSource
                .flatMap(new MyFlatMapFunction())
                .groupBy(0)
                .sum(1);
        sum.print();
//        executionEnvironment.execute("DataSetDemo");
    }
}

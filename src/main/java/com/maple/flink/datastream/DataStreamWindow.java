//package com.maple.flink.datastream;
//
//import com.maple.flink.aggregate.CountPeopleAccmulator;
//import com.maple.flink.aggregate.CountPeopleAggFunction;
//import com.maple.flink.filter.MyFilterFunction;
//import com.maple.flink.flatmap.MyFlatMapFunction;
//import com.maple.flink.keyby.MyKeyByFunction;
//import org.apache.flink.api.common.eventtime.WatermarkGenerator;
//import org.apache.flink.api.common.eventtime.WatermarkGeneratorSupplier;
//import org.apache.flink.api.common.eventtime.WatermarkOutput;
//import org.apache.flink.api.common.eventtime.WatermarkStrategy;
//import org.apache.flink.api.java.tuple.Tuple2;
//import org.apache.flink.streaming.api.TimeCharacteristic;
//import org.apache.flink.streaming.api.datastream.DataStream;
//import org.apache.flink.streaming.api.datastream.DataStreamSource;
//import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
//import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
//import org.apache.flink.streaming.api.windowing.time.Time;
//
//public class DataStreamWindow {
//    public static void main(String[] args) throws Exception {
//
//        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        env.setParallelism(1);
//        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
//        DataStreamSource<String> dataStreamSource = env.socketTextStream("localhost", 9999);
//
//        DataStream<Tuple2<String, Long>> dataStream = dataStreamSource
//                .flatMap(new MyFlatMapFunction()).assignTimestampsAndWatermarks(new WatermarkStrategy<Tuple2<String, Long>>() {
//                    @Override
//                    public WatermarkGenerator<Tuple2<String, Long>> createWatermarkGenerator(WatermarkGeneratorSupplier.Context context) {
//                        return new WatermarkGenerator<Tuple2<String, Long>>() {
//                            @Override
//                            public void onEvent(Tuple2<String, Long> event, long eventTimestamp, WatermarkOutput output) {
//
//                            }
//
//                            @Override
//                            public void onPeriodicEmit(WatermarkOutput output) {
//
//                            }
//                        }
//                    }
//                });
//
////                .keyBy(new MyKeyByFunction())
////                .sum(1);
////
////      .assignAscendingTimestamps(_.timestamp * 1000L)
//
//        DataStream<CountPeopleAccmulator> adCountStream = dataStream
//                .keyBy(0)
//                .timeWindow(Time.seconds(2L))
//                .aggregate(new CountPeopleAggFunction());
//
//        adCountStream.print();
//        env.execute("ad analysis job");
//    }
//}

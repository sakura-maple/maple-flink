package com.maple.flink.aggregate;

import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountPeopleAggFunction
		implements AggregateFunction<Tuple2<String, Long>,CountPeopleAccmulator, CountPeopleAccmulator> {

	private static final Logger log = LoggerFactory.getLogger(CountPeopleAggFunction.class);
	/**
	* 
	*/
	private static final long serialVersionUID = 7704719103999695202L;

	@Override
	public CountPeopleAccmulator createAccumulator() {
		return new CountPeopleAccmulator();
	}

	@Override
	public CountPeopleAccmulator add(Tuple2<String, Long> value, CountPeopleAccmulator accumulator) {
		accumulator.setId(value.f0);
		accumulator.setConunt(value.f1);
		return accumulator;
	}

	@Override
	public CountPeopleAccmulator getResult(CountPeopleAccmulator accumulator) {
		return accumulator;
	}

	@Override
	public CountPeopleAccmulator merge(CountPeopleAccmulator a, CountPeopleAccmulator b) {
		a.setConunt(a.getConunt() + b.getConunt());
		return a;
	}
}
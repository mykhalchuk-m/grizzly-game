package com.game.grizzly.core.statistic;

import java.util.HashMap;
import java.util.Map;

public class SuccessCounter {
	private Map<SuccessType, Integer> counter;

	public SuccessCounter() {
		counter = new HashMap<SuccessType, Integer>();
		for (SuccessType successType : SuccessType.values()) {
			counter.put(successType, 0);
		}
	}

	void incCounter(SuccessType successType) {
		counter.put(successType, counter.get(successType));
	}
	
	@Override
	public String toString() {
		return counter.toString();
	}

}

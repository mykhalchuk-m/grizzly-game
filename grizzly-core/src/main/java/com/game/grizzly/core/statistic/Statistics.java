package com.game.grizzly.core.statistic;

import java.util.Map;

import com.game.grizzly.core.skill.serves.ServeType;
import com.game.grizzly.core.skill.strike.StrikeType;

public class Statistics {
	private Map<ServeType, SuccessCounter> successServes;
	private Map<StrikeType, SuccessCounter> successStrikes;

	public void registerServeAs(ServeType serveType, SuccessType successType) {
		SuccessCounter successCounter = successServes.get(serveType);
		if (null == successCounter) {
			successCounter = new SuccessCounter();
		}
		successCounter.incCounter(serveType, successType);
		successServes.put(serveType, successCounter);
	}

	public void registerStrikeAs(StrikeType strikeType, SuccessType successType) {
		SuccessCounter successCounter = successStrikes.get(strikeType);
		if (null == successCounter) {
			successCounter = new SuccessCounter();
		}
		successCounter.incCounter(strikeType, successType);
		successStrikes.put(strikeType, successCounter);
	}
}
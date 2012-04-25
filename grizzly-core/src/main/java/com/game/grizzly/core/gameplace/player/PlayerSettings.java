package com.game.grizzly.core.gameplace.player;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.game.grizzly.core.skill.serves.ServeType;
import com.game.grizzly.core.skill.strike.StrikeType;

public class PlayerSettings {
	private Map<Integer, ServeType> serves;
	private Map<Integer, StrikeType> strikes;

	private static final String EXCEPTION_MESSAGE = "Order of serve can not be negative";
	private Random random = new Random();
	
	public PlayerSettings() {
		serves = new HashMap<Integer, ServeType>();
		strikes = new HashMap<Integer, StrikeType>();
	}

	public void registerServeAs(int serveOrder, ServeType serveType) {
		if (serveOrder < 0) {
			throw new NegativeArraySizeException(EXCEPTION_MESSAGE);
		}
		serves.put(serveOrder, serveType);
	}

	public ServeType getServeByOrder(int serveNumber) {
		return serves.get(serveNumber);
	}
	
	public void registerStrikeAs(StrikeType strikeType) {
		strikes.put(strikes.size(), strikeType);
	}
	
	public StrikeType getStrikeType() {
		if (strikes.size() == 0) {
			return null;
		}
		int key = random.nextInt(strikes.size());
		StrikeType strikeType = strikes.get(key);
		strikes.remove(key);
		return strikeType;
	}
}

package com.game.grizzly.core.skill.strike;

import java.util.HashMap;
import java.util.Map;

import com.game.grizzly.core.skill.Skill;

public class StrikeFactory {
	private static Map<StrikeType, Skill> strikes = new HashMap<StrikeType, Skill>();
	
	public StrikeFactory() {
		strikes.put(StrikeType.CURVED, new CurvedStrike());
		strikes.put(StrikeType.SMASH, new SmashStrike());
	}
	
	public Skill getSkill(StrikeType key) {
		return strikes.get(key);
	}
}

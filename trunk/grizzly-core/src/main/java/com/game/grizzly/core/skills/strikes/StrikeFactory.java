package com.game.grizzly.core.skills.strikes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.grizzly.core.skills.AbstractSkillFactory;

public class StrikeFactory extends AbstractSkillFactory {

	private static Map<StrikeType, Strike> strikes = new HashMap<StrikeType, Strike>();

	public StrikeFactory() {
		strikes.put(StrikeType.STRIKE_CURVED, new CurvedStrike());
		strikes.put(StrikeType.STRIKE_SMASH, new SmashStrike());
	}

	@Override
	public Strike getSkill(String key) {
		Strike strike = strikes.get(StrikeType.valueOf(key));
		return strike;
	}

	@Override
	public List<String> getSkillTypes() {
		return StrikeType.getStringValues();
	}

}

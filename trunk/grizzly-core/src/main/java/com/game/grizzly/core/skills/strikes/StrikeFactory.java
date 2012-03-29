package com.game.grizzly.core.skills.strikes;

import java.util.HashMap;
import java.util.Map;

import com.game.grizzly.core.skills.AbstractSkillFactory;

public class StrikeFactory extends AbstractSkillFactory<Strike, StrikeType>{

	private static Map<StrikeType, Strike> strikes = new HashMap<StrikeType, Strike>();
	
	static {
		strikes.put(StrikeType.CURVED, new CurvedStrike());
		strikes.put(StrikeType.SMASH, new SmashStrike());
	}
	
	@Override
	public Strike getSkill(StrikeType e, double value) {
		Strike strike = strikes.get(e);
		strike.setValue(value);
		return strike;
	}

}

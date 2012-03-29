package com.game.grizzly.core.skills;

import java.util.HashMap;
import java.util.Map;

import com.game.grizzly.core.skills.defence.DefenceFactory;
import com.game.grizzly.core.skills.serveacceptances.ServeAcceptanceFactory;
import com.game.grizzly.core.skills.serves.ServeFactory;
import com.game.grizzly.core.skills.strikes.StrikeFactory;

public class SkillFactory {
	private static Map<SkillGroupType, AbstractSkillFactory<?, ?>> skillFactories = new HashMap<SkillGroupType, AbstractSkillFactory<?, ?>>();

	static {
		skillFactories.put(SkillGroupType.DEFENCE, new DefenceFactory());
		skillFactories.put(SkillGroupType.SERVE, new ServeFactory());
		skillFactories.put(SkillGroupType.ACCEPTENCE_SERVE,
				new ServeAcceptanceFactory());
		skillFactories.put(SkillGroupType.STRIKE, new StrikeFactory());
	}

	public static AbstractSkillFactory<?, ?> getSkillFactory(SkillGroupType skillType) {
		return skillFactories.get(skillType);
	}

}

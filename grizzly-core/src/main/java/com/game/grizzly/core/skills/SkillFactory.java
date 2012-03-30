package com.game.grizzly.core.skills;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.grizzly.core.skills.defence.DefenceFactory;
import com.game.grizzly.core.skills.passive.PasiveSkillFactory;
import com.game.grizzly.core.skills.serveacceptances.ServeAcceptanceFactory;
import com.game.grizzly.core.skills.serves.ServeFactory;
import com.game.grizzly.core.skills.strikes.StrikeFactory;

public class SkillFactory {
	private Map<SkillGroupType, AbstractSkillFactory> skillFactories;

	private void init() {
		skillFactories = new HashMap<SkillGroupType, AbstractSkillFactory>();
		skillFactories.put(SkillGroupType.DEFENCE, new DefenceFactory());
		skillFactories.put(SkillGroupType.SERVE, new ServeFactory());
		skillFactories.put(SkillGroupType.PASIVE, new PasiveSkillFactory());
		skillFactories.put(SkillGroupType.ACCEPTENCE_SERVE,
				new ServeAcceptanceFactory());
		skillFactories.put(SkillGroupType.STRIKE, new StrikeFactory());
	}

	public Map<SkillType, Skill> initSkills() {
		init();
		Map<SkillType, Skill> skills = new HashMap<SkillType, Skill>();
		for (SkillGroupType groupType : SkillGroupType.values()) {
			AbstractSkillFactory factory = skillFactories.get(groupType);
			List<String> skillTypes = factory.getSkillTypes();
			for (String skillType : skillTypes) {
				skills.put(SkillType.valueOf(skillType),
						factory.getSkill(skillType));
			}
		}
		return skills;
	}

}

package com.game.grizzly.core.skills.passive;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.grizzly.core.skills.AbstractSkillFactory;

public class PasiveSkillFactory extends AbstractSkillFactory {

	private Map<PasiveSkillType, PasiveSkill> pasiveSkills = new HashMap<PasiveSkillType, PasiveSkill>();

	public PasiveSkillFactory() {
		pasiveSkills.put(PasiveSkillType.PASIVE_STAMINA, new Stamian());
	}

	@Override
	public PasiveSkill getSkill(String key) {
		PasiveSkill pasiveSkill = pasiveSkills
				.get(PasiveSkillType.valueOf(key));
		return pasiveSkill;
	}

	@Override
	public List<String> getSkillTypes() {
		return PasiveSkillType.getStringValues();
	}

}

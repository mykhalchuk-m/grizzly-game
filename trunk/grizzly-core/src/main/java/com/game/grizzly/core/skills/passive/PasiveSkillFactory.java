package com.game.grizzly.core.skills.passive;

import java.util.HashMap;
import java.util.Map;

import com.game.grizzly.core.skills.AbstractSkillFactory;

public class PasiveSkillFactory extends AbstractSkillFactory<PasiveSkill, PasiveSkillType> {

	private static Map<PasiveSkillType, PasiveSkill> pasiveSkills = new HashMap<PasiveSkillType, PasiveSkill>();
	
	static {
		pasiveSkills.put(PasiveSkillType.STAMINA, new Stamian());
	}
	
	@Override
	public PasiveSkill getSkill(PasiveSkillType e, double value) {
		PasiveSkill pasiveSkill = pasiveSkills.get(e);
		pasiveSkill.setValue(value);
		return pasiveSkill;
	}

}

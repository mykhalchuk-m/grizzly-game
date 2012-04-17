package com.game.grizzly.core.skill.passive;

import java.util.HashMap;
import java.util.Map;

import com.game.grizzly.core.skill.Skill;

public class PasiveSkillFactory {

	private Map<PasiveSkillType, Skill> pasiveSkills = new HashMap<PasiveSkillType, Skill>();

	public PasiveSkillFactory() {
		pasiveSkills.put(PasiveSkillType.STAMINA, new Stamian());
		pasiveSkills.put(PasiveSkillType.CRYTICAL_STRICE, new CryticalStrike());
		pasiveSkills.put(PasiveSkillType.REACTION, new Reaction());
		pasiveSkills.put(PasiveSkillType.REGENERATION, new Regeneration());
	}

	public Skill getSkill(String key) {
		Skill pasiveSkill = pasiveSkills
				.get(PasiveSkillType.valueOf(key));
		return pasiveSkill;
	}

}
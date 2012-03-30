package com.game.grizzly.core.gameplace;

import java.util.HashMap;
import java.util.Map;

import com.game.grizzly.core.skills.Skill;
import com.game.grizzly.core.skills.SkillType;

public class Player {
	private String name;
	private Map<SkillType, Skill> skills = new HashMap<SkillType, Skill>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<SkillType, Skill> getSkills() {
		return skills;
	}

	public void setSkills(Map<SkillType, Skill> skills) {
		this.skills = skills;
	}

	public double getSkillValue(SkillType skillType) {
		return skills.get(skillType).doAction();
	}
	
	public void setSkill(SkillType skillType, double value) {
		Skill skill = skills.get(skillType);
		skill.setValue(value);
		skills.put(skillType, skill);
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name + ", skills=" + skills + "]";
	}

}

package com.game.grizzly.core.gameplace;

import java.util.List;
import java.util.Map;

import com.game.grizzly.core.skills.Skill;
import com.game.grizzly.core.skills.SkillGroupType;
import com.game.grizzly.core.skills.SkillType;

public class Player {
	private String name;
	private Map<SkillGroupType, Map<SkillType, Skill>> map;
	private List<Skill> skills;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Map<SkillGroupType, Map<SkillType, Skill>> getMap() {
		return map;
	}

	public void setMap(Map<SkillGroupType, Map<SkillType, Skill>> map) {
		this.map = map;
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name + ", skills=" + skills + "]";
	}
}

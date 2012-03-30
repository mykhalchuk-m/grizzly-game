package com.game.grizzly.core.skills;

import java.util.List;

public abstract class AbstractSkillFactory {

	public abstract Skill getSkill(String key);

	public abstract List<String> getSkillTypes();
}

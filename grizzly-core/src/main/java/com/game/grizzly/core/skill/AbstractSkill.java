package com.game.grizzly.core.skill;

public abstract class AbstractSkill implements Skill {

	private int value;
	
	public void setSkillValue(int value) {
		this.value = value;
	}
	
	public int doAction() {
		return value;
	}

}

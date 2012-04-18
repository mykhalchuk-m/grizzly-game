package com.game.grizzly.core.skill;

public abstract class AbstractSkill implements Skill {

	private double value;
	
	public void setSkillValue(double value) {
		this.value = value;
	}
	
	public double doAction() {
		return value;
	}
	
	@Override
	public String toString() {
		return "[" + getClass().getSimpleName() + " -> " + value + "]";
	}

}

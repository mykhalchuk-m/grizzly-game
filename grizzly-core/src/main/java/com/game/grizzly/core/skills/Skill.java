package com.game.grizzly.core.skills;

public class Skill {
	private double value;

	public void setValue(double value) {
		this.value = value;
	}

	public double doAction() {
		return value;
	}
	
	@Override
	public String toString() {
		return "[" + getClass().getName() + " -> " + value + "]\n";
	}
}

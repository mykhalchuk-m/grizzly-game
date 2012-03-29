package com.game.grizzly.core.skills;


public abstract class AbstractSkillFactory<T, E> {
	
	public abstract T getSkill(E e, double value);
}

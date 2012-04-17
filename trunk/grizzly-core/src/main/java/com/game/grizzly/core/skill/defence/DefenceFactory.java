package com.game.grizzly.core.skill.defence;

import java.util.HashMap;
import java.util.Map;

import com.game.grizzly.core.skill.Skill;

public class DefenceFactory {
	private static Map<DefenceType, Skill> defences = new HashMap<DefenceType, Skill>();
	
	public DefenceFactory() {
		defences.put(DefenceType.CURVED, new CurvedDefence());
		defences.put(DefenceType.SMASH, new SmashDefence());
	}
	
	public Skill getSkill(DefenceType key) {
		Skill strike = defences.get(key);
		return strike;
	}
}

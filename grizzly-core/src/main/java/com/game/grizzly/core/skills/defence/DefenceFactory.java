package com.game.grizzly.core.skills.defence;

import java.util.HashMap;
import java.util.Map;

import com.game.grizzly.core.skills.AbstractSkillFactory;

public class DefenceFactory extends AbstractSkillFactory<Defence, DefenceType> {

	private static Map<DefenceType, Defence> defences = new HashMap<DefenceType, Defence>();

	static {
		defences.put(DefenceType.CURVED, new CurvedDefence());
		defences.put(DefenceType.SMASH, new SmashDefence());
	}

	@Override
	public Defence getSkill(DefenceType e, double value) {
		Defence defence = defences.get(e);
		defence.setValue(value);
		return defence;
	}

}

package com.game.grizzly.core.skills.defence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.grizzly.core.skills.AbstractSkillFactory;

public class DefenceFactory extends AbstractSkillFactory {

	private Map<DefenceType, Defence> defences = new HashMap<DefenceType, Defence>();

	public DefenceFactory() {
		defences.put(DefenceType.DEFENCE_CURVED, new CurvedDefence());
		defences.put(DefenceType.DEFENCE_SMASH, new SmashDefence());
	}

	@Override
	public Defence getSkill(String key) {
		Defence defence = defences.get(DefenceType.valueOf(key));
		return defence;
	}

	@Override
	public List<String> getSkillTypes() {
		return DefenceType.getStringValues();
	}

}

package com.game.grizzly.core.skills;

import java.util.ArrayList;
import java.util.List;

public enum SkillType {
	
	DEFENCE_SMASH, DEFENCE_CURVED, PASIVE_STAMINA, ACCEPTENCE_SERVE_CURVED_TO_LEFT, 
	ACCEPTENCE_SERVE_CURVED_TO_RIGHT, SERVE_CURVE_TO_LEFT, SERVE_CURVE_TO_RIGHT, 
	STRIKE_SMASH, STRIKE_CURVED;
	
	public List<SkillType> getSubskills(SkillGroupType groupType) {
		List<SkillType> skillTypes = new ArrayList<SkillType>();
		for (SkillType skillType : values()) {
			if (skillType.toString().startsWith(groupType.toString())) {
				skillTypes.add(skillType);
			}
		}
		return skillTypes;
	}
}

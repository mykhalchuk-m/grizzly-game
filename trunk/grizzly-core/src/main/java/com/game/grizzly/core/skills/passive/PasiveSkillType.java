package com.game.grizzly.core.skills.passive;

import java.util.ArrayList;
import java.util.List;

public enum PasiveSkillType {
	PASIVE_STAMINA;
	
	public static List<String> getStringValues() {
		List<String> list = new ArrayList<String>();
		for (PasiveSkillType defenceType : values()) {
			list.add(defenceType.toString());
		}
		return list;
	}
}

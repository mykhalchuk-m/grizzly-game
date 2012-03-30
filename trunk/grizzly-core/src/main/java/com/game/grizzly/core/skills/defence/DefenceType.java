package com.game.grizzly.core.skills.defence;

import java.util.ArrayList;
import java.util.List;

public enum DefenceType {
	DEFENCE_SMASH, DEFENCE_CURVED;
	
	public static List<String> getStringValues() {
		List<String> list = new ArrayList<String>();
		for (DefenceType defenceType : values()) {
			list.add(defenceType.toString());
		}
		return list;
	}
}

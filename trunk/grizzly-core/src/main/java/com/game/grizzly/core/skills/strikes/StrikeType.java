package com.game.grizzly.core.skills.strikes;

import java.util.ArrayList;
import java.util.List;

public enum StrikeType {
	STRIKE_SMASH, STRIKE_CURVED;
	
	public static List<String> getStringValues() {
		List<String> list = new ArrayList<String>();
		for (StrikeType defenceType : values()) {
			list.add(defenceType.toString());
		}
		return list;
	}
}

package com.game.grizzly.core.skills.serves;

import java.util.ArrayList;
import java.util.List;

public enum ServeType {
	SERVE_CURVE_TO_LEFT, SERVE_CURVE_TO_RIGHT;
	
	public static List<String> getStringValues() {
		List<String> list = new ArrayList<String>();
		for (ServeType defenceType : values()) {
			list.add(defenceType.toString());
		}
		return list;
	}
}

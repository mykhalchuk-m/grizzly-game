package com.game.grizzly.core.skills.serveacceptances;

import java.util.ArrayList;
import java.util.List;

public enum ServeAcceptenceType {
	ACCEPTENCE_SERVE_CURVED_TO_LEFT, ACCEPTENCE_SERVE_CURVED_TO_RIGHT;
	
	public static List<String> getStringValues() {
		List<String> list = new ArrayList<String>();
		for (ServeAcceptenceType defenceType : values()) {
			list.add(defenceType.toString());
		}
		return list;
	}
}

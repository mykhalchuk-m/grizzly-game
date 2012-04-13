package com.game.grizzly.core.skill.serves;

import java.util.HashMap;
import java.util.Map;

import com.game.grizzly.core.skill.Skill;

public class ServeFactory {
	private static Map<ServeType, Skill> serves = new HashMap<ServeType, Skill>();
	
	public ServeFactory() {
		serves.put(ServeType.CURVE_TO_LEFT, new CurvedToLeftServe());
		serves.put(ServeType.CURVE_TO_RIGHT, new CurvedToRightServe());
	}
	
	public Skill getSkill(String key) {
		Skill serve = serves.get(ServeType.valueOf(key));
		return serve;
	}

}

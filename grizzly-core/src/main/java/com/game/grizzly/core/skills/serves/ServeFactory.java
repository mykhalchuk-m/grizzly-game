package com.game.grizzly.core.skills.serves;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.grizzly.core.skills.AbstractSkillFactory;

public class ServeFactory extends AbstractSkillFactory {
	private static Map<ServeType, Serve> serves = new HashMap<ServeType, Serve>();
	
	public ServeFactory() {
		serves.put(ServeType.SERVE_CURVE_TO_LEFT, new CurvedToLeftServe());
		serves.put(ServeType.SERVE_CURVE_TO_RIGHT, new CurvedToRightServe());
	}
	
	public Serve getSkill(String key) {
		Serve serve = serves.get(ServeType.valueOf(key));
		return serve;
	}
	
	@Override
	public List<String> getSkillTypes() {
		return ServeType.getStringValues();
	}
}

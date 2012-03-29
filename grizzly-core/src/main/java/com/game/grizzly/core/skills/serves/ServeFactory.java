package com.game.grizzly.core.skills.serves;

import java.util.HashMap;
import java.util.Map;

import com.game.grizzly.core.skills.AbstractSkillFactory;

public class ServeFactory extends AbstractSkillFactory<Serve, ServeType> {
	private static Map<ServeType, Serve> serves = new HashMap<ServeType, Serve>();
	
	static {
		serves.put(ServeType.CURVE_TO_LEFT, new CurvedToLeftServe());
		serves.put(ServeType.CURVE_TO_RIGHT, new CurvedToRightServe());
	}
	
	public Serve getSkill(ServeType serveType, double value) {
		Serve serve = serves.get(serveType);
		serve.setValue(value);
		return serve;
	}
}

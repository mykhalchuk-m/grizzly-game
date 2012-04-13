package com.game.grizzly.core.skill.serveacceptances;

import java.util.HashMap;
import java.util.Map;

import com.game.grizzly.core.skill.Skill;

public class ServeAcceptanceFactory {
	private static Map<ServeAcceptenceType, Skill> serveAcceptences = new HashMap<ServeAcceptenceType, Skill>();

	public ServeAcceptanceFactory() {
		serveAcceptences.put(ServeAcceptenceType.CURVED_TO_LEFT,
				new AcceptCurvedToLeftServe());
		serveAcceptences.put(ServeAcceptenceType.CURVED_TO_RIGHT,
				new AcceptCurvedToRightServe());
	}

	public Skill getSkill(String key) {
		Skill serveAcceptance = serveAcceptences.get(ServeAcceptenceType
				.valueOf(key));
		return serveAcceptance;
	}
}

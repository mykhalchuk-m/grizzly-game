package com.game.grizzly.core.skills.serveacceptances;

import java.util.HashMap;
import java.util.Map;

import com.game.grizzly.core.skills.AbstractSkillFactory;

public class ServeAcceptanceFactory extends AbstractSkillFactory<ServeAcceptance, ServeAcceptenceType>{
	private static Map<ServeAcceptenceType, ServeAcceptance> serveAcceptences = new HashMap<ServeAcceptenceType, ServeAcceptance>();

	static {
		serveAcceptences.put(ServeAcceptenceType.ACCEPT_CURVED_TO_LEFT,
				new AcceptCurvedToLeftServe());
		serveAcceptences.put(ServeAcceptenceType.ACCEPT_CURVED_TO_RIGHT,
				new AcceptCurvedToRightServe());
	}

	public ServeAcceptance getSkill(
			ServeAcceptenceType acceptenceType, double value) {
		ServeAcceptance serveAcceptance = serveAcceptences.get(acceptenceType);
		serveAcceptance.setValue(value);
		return serveAcceptance;
	}
}

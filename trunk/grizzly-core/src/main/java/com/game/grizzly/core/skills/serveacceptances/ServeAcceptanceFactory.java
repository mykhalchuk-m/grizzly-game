package com.game.grizzly.core.skills.serveacceptances;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.grizzly.core.skills.AbstractSkillFactory;

public class ServeAcceptanceFactory extends AbstractSkillFactory {
	private static Map<ServeAcceptenceType, ServeAcceptance> serveAcceptences = new HashMap<ServeAcceptenceType, ServeAcceptance>();

	public ServeAcceptanceFactory() {
		serveAcceptences.put(ServeAcceptenceType.ACCEPTENCE_SERVE_CURVED_TO_LEFT,
				new AcceptCurvedToLeftServe());
		serveAcceptences.put(ServeAcceptenceType.ACCEPTENCE_SERVE_CURVED_TO_RIGHT,
				new AcceptCurvedToRightServe());
	}

	public ServeAcceptance getSkill(String key) {
		ServeAcceptance serveAcceptance = serveAcceptences
				.get(ServeAcceptenceType.valueOf(key));
		return serveAcceptance;
	}
	
	@Override
	public List<String> getSkillTypes() {
		return ServeAcceptenceType.getStringValues();
	}
}

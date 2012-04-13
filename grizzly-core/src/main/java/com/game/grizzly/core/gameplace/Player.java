package com.game.grizzly.core.gameplace;

import java.util.HashMap;
import java.util.Map;

import com.game.grizzly.core.skill.Skill;
import com.game.grizzly.core.skill.passive.PasiveSkillType;
import com.game.grizzly.core.skill.serveacceptances.ServeAcceptenceType;
import com.game.grizzly.core.skill.serves.ServeType;

public class Player {
	private String name;
	private Map<ServeType, Skill> serves = new HashMap<ServeType, Skill>();
	private Map<ServeAcceptenceType, Skill> servesAcceptence = new HashMap<ServeAcceptenceType, Skill>();
	private Map<PasiveSkillType, Skill> pasives = new HashMap<PasiveSkillType, Skill>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<ServeType, Skill> getServes() {
		return serves;
	}

	public void setServes(Map<ServeType, Skill> serves) {
		this.serves = serves;
	}

	public Map<ServeAcceptenceType, Skill> getServesAcceptence() {
		return servesAcceptence;
	}

	public void setServesAcceptence(
			Map<ServeAcceptenceType, Skill> servesAcceptence) {
		this.servesAcceptence = servesAcceptence;
	}

	public Map<PasiveSkillType, Skill> getPasives() {
		return pasives;
	}

	public void setPasives(Map<PasiveSkillType, Skill> pasives) {
		this.pasives = pasives;
	}

	public Skill getServe(ServeType serveType) {
		return serves.get(serveType);
	}

	public Skill getServesAcceptence(ServeAcceptenceType acceptenceType) {
		return servesAcceptence.get(acceptenceType);
	}

	public Skill getPasiveSkill(PasiveSkillType pasiveSkillType) {
		return pasives.get(pasiveSkillType);
	}
}

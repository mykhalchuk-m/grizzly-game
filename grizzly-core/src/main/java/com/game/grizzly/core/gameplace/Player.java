package com.game.grizzly.core.gameplace;

import java.util.HashMap;
import java.util.Map;

import com.game.grizzly.core.skill.Skill;
import com.game.grizzly.core.skill.defence.DefenceType;
import com.game.grizzly.core.skill.passive.PasiveSkillType;
import com.game.grizzly.core.skill.serveacceptances.ServeAcceptenceType;
import com.game.grizzly.core.skill.serves.ServeType;
import com.game.grizzly.core.skill.strike.StrikeType;

public class Player {
	private String name;
	private int score;
	private Map<ServeType, Skill> serves = new HashMap<ServeType, Skill>();
	private Map<ServeAcceptenceType, Skill> servesAcceptence = new HashMap<ServeAcceptenceType, Skill>();
	private Map<PasiveSkillType, Skill> pasives = new HashMap<PasiveSkillType, Skill>();
	private Map<StrikeType, Skill> strikes = new HashMap<StrikeType, Skill>();
	private Map<DefenceType, Skill> defences = new HashMap<DefenceType, Skill>();

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

	public void setServesAcceptence(Map<ServeAcceptenceType, Skill> servesAcceptence) {
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
	
	public Skill getStrike(StrikeType strikeType) {
		return strikes.get(strikeType);
	}
	
	public Skill getDefence(DefenceType defenceType) {
		return defences.get(defenceType);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void incScore(int incValue) {
		score += incValue;
	}

	public Map<StrikeType, Skill> getStrikes() {
		return strikes;
	}

	public void setStrikes(Map<StrikeType, Skill> strikes) {
		this.strikes = strikes;
	}

	public Map<DefenceType, Skill> getDefences() {
		return defences;
	}

	public void setDefences(Map<DefenceType, Skill> defences) {
		this.defences = defences;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + ", serves=" + serves + ", servesAcceptence="
				+ servesAcceptence + ", pasives=" + pasives + ", strikes=" + strikes + ", defences=" + defences + "]";
	}
	
	
}

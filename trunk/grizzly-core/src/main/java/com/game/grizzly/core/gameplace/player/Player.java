package com.game.grizzly.core.gameplace.player;

import java.util.HashMap;
import java.util.Map;

import com.game.grizzly.core.skill.Skill;
import com.game.grizzly.core.skill.defence.DefenceType;
import com.game.grizzly.core.skill.passive.PasiveSkillType;
import com.game.grizzly.core.skill.serveacceptances.ServeAcceptenceType;
import com.game.grizzly.core.skill.serves.ServeType;
import com.game.grizzly.core.skill.strike.StrikeType;
import com.game.grizzly.core.statistic.Statistics;

public class Player {
	private String name;
	private Map<ServeType, Skill> serves = new HashMap<ServeType, Skill>();
	private Map<ServeAcceptenceType, Skill> servesAcceptence = new HashMap<ServeAcceptenceType, Skill>();
	private Map<PasiveSkillType, Skill> pasives = new HashMap<PasiveSkillType, Skill>();
	private Map<StrikeType, Skill> strikes = new HashMap<StrikeType, Skill>();
	private Map<DefenceType, Skill> defences = new HashMap<DefenceType, Skill>();
	private Statistics statistics = new Statistics();

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", serves=" + serves + ", servesAcceptence=" + servesAcceptence + ", pasives="
				+ pasives + ", strikes=" + strikes + ", defences=" + defences + "]";
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

}

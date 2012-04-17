package com.game.grizzly.core.gameplace;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.game.grizzly.core.skill.Skill;
import com.game.grizzly.core.skill.defence.DefenceFactory;
import com.game.grizzly.core.skill.defence.DefenceType;
import com.game.grizzly.core.skill.passive.PasiveSkillFactory;
import com.game.grizzly.core.skill.passive.PasiveSkillType;
import com.game.grizzly.core.skill.serveacceptances.ServeAcceptanceFactory;
import com.game.grizzly.core.skill.serveacceptances.ServeAcceptenceType;
import com.game.grizzly.core.skill.serves.ServeFactory;
import com.game.grizzly.core.skill.serves.ServeType;
import com.game.grizzly.core.skill.strike.StrikeFactory;
import com.game.grizzly.core.skill.strike.StrikeType;

public class SkillsGenerator {
	private Random random = new Random();

	public Player getnerateServes(Player player) {
		ServeFactory serveFactory = new ServeFactory();
		Map<ServeType, Skill> map = new HashMap<ServeType, Skill>();
		for (ServeType serveType : ServeType.values()) {
			Skill skill = serveFactory.getSkill(serveType);
			skill.setSkillValue(20 + random.nextInt(10));
			map.put(serveType, skill);
		}
		player.setServes(map);
		return player;
	}

	public Player generateServesAcceptence(Player player) {
		ServeAcceptanceFactory acceptanceFactory = new ServeAcceptanceFactory();
		Map<ServeAcceptenceType, Skill> map = new HashMap<ServeAcceptenceType, Skill>();
		for (ServeAcceptenceType acceptenceType : ServeAcceptenceType.values()) {
			Skill skill = acceptanceFactory.getSkill(acceptenceType);
			skill.setSkillValue(20 + random.nextInt(10));
			map.put(acceptenceType, skill);
		}
		player.setServesAcceptence(map);
		return player;
	}
	
	public Player generatePasive(Player player) {
		PasiveSkillFactory pasiveSkillFactory = new PasiveSkillFactory();
		Map<PasiveSkillType, Skill> map = new HashMap<PasiveSkillType, Skill>();
		Skill skill = pasiveSkillFactory.getSkill(PasiveSkillType.STAMINA);
		skill.setSkillValue(90);
		map.put(PasiveSkillType.STAMINA, skill);
		skill = pasiveSkillFactory.getSkill(PasiveSkillType.CRYTICAL_STRICE);
		skill.setSkillValue(7);
		map.put(PasiveSkillType.CRYTICAL_STRICE, skill);
		player.setPasives(map);
		return player;
	}
	
	public Player generateStrikes(Player player) {
		StrikeFactory strikeFactory = new StrikeFactory();
		Map<StrikeType, Skill> map = new HashMap<StrikeType, Skill>();
		for (StrikeType key : StrikeType.values()) {
			Skill skill = strikeFactory.getSkill(key);
			skill.setSkillValue(20 + random.nextInt(10));
			map.put(key, skill);
		}
		player.setStrikes(map);
		return player;
	}
	
	public Player generateDefences(Player player) {
		DefenceFactory defenceFactory = new DefenceFactory();
		Map<DefenceType, Skill> map = new HashMap<DefenceType, Skill>();
		for (DefenceType defenceType : DefenceType.values()) {
			Skill skill = defenceFactory.getSkill(defenceType);
			skill.setSkillValue(20 + random.nextInt(10));
			map.put(defenceType, skill);
		}
		player.setDefences(map);
		return player;
	}
}
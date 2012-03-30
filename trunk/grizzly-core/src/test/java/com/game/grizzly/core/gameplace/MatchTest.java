package com.game.grizzly.core.gameplace;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.game.grizzly.core.skills.SkillFactory;
import com.game.grizzly.core.skills.SkillType;

public class MatchTest {
	private Match match = new Match();

	@Before
	public void init() {
		SkillFactory skillFactory = new SkillFactory();
		Player player1 = new Player();
		player1.setName("player1");
		player1.setSkills(skillFactory.initSkills());
		initSkills(player1);
		Player player2 = new Player();
		player2.setName("player2");
		player2.setSkills(skillFactory.initSkills());
		initSkills(player2);
		List<Player> players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);

		Score score = new Score();

		match.setMatchScore(score);
		match.setMatchState(MatchState.STARTED);
		match.setPlayers(players);
	}

	private void initSkills(Player player) {
		Properties properties = data();
		for (SkillType skillType : SkillType.values()) {
			player.setSkill(skillType, Double.parseDouble(properties
					.getProperty(skillType.toString())));
		}
	}

	@Test
	public void initGame() {
		match.playMatch();
		System.out.println(match.getPlayers().get(0));
		System.out.println(match.getPlayers().get(1));
	}

	private Properties data() {
		Properties properties = new Properties();
		Random random = new Random();
		properties.setProperty(
				SkillType.ACCEPTENCE_SERVE_CURVED_TO_LEFT.toString(),
				Double.toString(0.5 + (double)random.nextInt(9) / 100));
		properties.setProperty(
				SkillType.ACCEPTENCE_SERVE_CURVED_TO_RIGHT.toString(),
				Double.toString(0.5 + (double)random.nextInt(9) / 100));
		properties.setProperty(SkillType.DEFENCE_CURVED.toString(),
				Double.toString(0.55 + (double)random.nextInt(9) / 100));
		properties.setProperty(SkillType.DEFENCE_SMASH.toString(),
				Double.toString(0.35 + (double)random.nextInt(9) / 100));
		properties.setProperty(SkillType.PASIVE_STAMINA.toString(),
				Double.toString(0.9 + (double)random.nextInt(9) / 100));
		properties.setProperty(SkillType.SERVE_CURVE_TO_LEFT.toString(),
				Double.toString(0.9 + (double)random.nextInt(9) / 100));
		properties.setProperty(SkillType.SERVE_CURVE_TO_RIGHT.toString(),
				Double.toString(0.5 + (double)random.nextInt(9) / 100));
		properties.setProperty(SkillType.STRIKE_CURVED.toString(),
				Double.toString(0.2 + (double)random.nextInt(9) / 100));
		properties.setProperty(SkillType.STRIKE_SMASH.toString(),
				Double.toString(0.7 + (double)random.nextInt(9) / 100));
		return properties;
	}
}

package com.game.grizzly.core.gameplace;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.game.grizzly.core.gameplace.match.Match;
import com.game.grizzly.core.gameplace.match.MatchRules;
import com.game.grizzly.core.gameplace.player.Player;
import com.game.grizzly.core.gameplace.utils.SkillsGenerator;

public class MatchTest {
	private static Logger logger = Logger.getLogger(MatchTest.class);
	private Match match = new Match();

	private static int MAX_SCORE = 11;
	private static int SERVES_PER_SET = 2;

	private Player player1;
	private Player player2;

	@BeforeClass
	public static void oneTimeSetUp() {
		Properties properties = new Properties();
		try {
			InputStream in = MatchTest.class.getClassLoader().getResourceAsStream("matchConfig.properties");
			properties.load(in);
			MAX_SCORE = Integer.parseInt(properties.get("max_score").toString());
			SERVES_PER_SET = Integer.parseInt(properties.get("serves_per_set").toString());
		} catch (Exception e) {
			logger.warn("Config file didt't find, default values were loaded");
		}
	}
	
	@Before
	public void initPlayMatch() {
		SkillsGenerator skillsGenerator = new SkillsGenerator();

		player1 = new Player();
		player1.setName("player1");
		player1 = skillsGenerator.getnerateServes(player1);
		player1 = skillsGenerator.generateServesAcceptence(player1);
		player1 = skillsGenerator.generatePasive(player1);
		player1 = skillsGenerator.generateStrikes(player1);
		player1 = skillsGenerator.generateDefences(player1);
		logger.info(player1);

		skillsGenerator.setLevel(9);
		player2 = new Player();
		player2.setName("player2");
		player2 = skillsGenerator.getnerateServes(player2);
		player2 = skillsGenerator.generateServesAcceptence(player2);
		player2 = skillsGenerator.generatePasive(player2);
		player2 = skillsGenerator.generateStrikes(player2);
		player2 = skillsGenerator.generateDefences(player2);
		logger.info(player2);

		List<Player> players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);

		match.setPlayers(players);
	}

	@Test
	public void testParamsPlayMatch() {
		MatchRules rules = new MatchRules();
		rules.setMaxScore(MAX_SCORE);
		rules.setServesPerSet(SERVES_PER_SET);
		List<Player> players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);
		match.setPlayers(players);
		match.setRules(rules);
		match.playMatch();
	}
}

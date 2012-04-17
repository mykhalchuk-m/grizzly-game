package com.game.grizzly.core.gameplace;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class MatchTest {
	private Logger logger = Logger.getLogger(getClass());
	private Match match = new Match();

	@Before
	public void initPlayMatch() {
		SkillsGenerator skillsGenerator = new SkillsGenerator();
		
		Player player1 = new Player();
		player1.setName("player1");
		player1 = skillsGenerator.getnerateServes(player1);
		player1 = skillsGenerator.generateServesAcceptence(player1);
		player1 = skillsGenerator.generatePasive(player1);
		player1 = skillsGenerator.generateStrikes(player1);
		player1 = skillsGenerator.generateDefences(player1);
		logger.info(player1);
		
		Player player2 = new Player();
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
	public void testPlayMatch() {
		match.playMatch();
	}	
}

package com.game.grizzly.core.gameplace;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.game.grizzly.core.gameplace.game.Game;
import com.game.grizzly.core.gameplace.game.GameRules;
import com.game.grizzly.core.gameplace.player.Player;
import com.game.grizzly.core.gameplace.utils.SkillsGenerator;
import com.game.grizzly.core.skill.serves.ServeType;
import com.game.grizzly.core.skill.strike.StrikeType;

public class GameTest {
	private static Logger logger = Logger.getLogger(MatchTest.class);
	
	private Player player1;
	private Player player2;
	private Game game = new Game();
	private GameRules gameRules = new GameRules();
	
	@Before
	public void init() {
		SkillsGenerator skillsGenerator = new SkillsGenerator();

		player1 = new Player();
		player1.setName("player1");
		player1 = skillsGenerator.getnerateServes(player1);
		player1 = skillsGenerator.generateServesAcceptence(player1);
		player1 = skillsGenerator.generatePasive(player1);
		player1 = skillsGenerator.generateStrikes(player1);
		player1 = skillsGenerator.generateDefences(player1);
		logger.info(player1);

		skillsGenerator.setLevel(1);
		player2 = new Player();
		player2.setName("player2");
		player2 = skillsGenerator.getnerateServes(player2);
		player2 = skillsGenerator.generateServesAcceptence(player2);
		player2 = skillsGenerator.generatePasive(player2);
		player2 = skillsGenerator.generateStrikes(player2);
		player2 = skillsGenerator.generateDefences(player2);
		
		player2.getPlayerSettings().registerServeAs(0, ServeType.CURVED_TO_LEFT);
		player2.getPlayerSettings().registerServeAs(1, ServeType.CURVED_TO_LEFT);
		player2.getPlayerSettings().registerServeAs(2, ServeType.CURVED_TO_LEFT);
		
		player2.getPlayerSettings().registerStrikeAs(StrikeType.CURVED);
		player2.getPlayerSettings().registerStrikeAs(StrikeType.CURVED);
		player2.getPlayerSettings().registerStrikeAs(StrikeType.CURVED);
		logger.info(player2);

		List<Player> players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);

		game.setPlayers(players);
	}
	
	@Test
	public void testPlayGame() {
		gameRules.setMatchCount(5);
		gameRules.setMaxScore(11);
		gameRules.setServesPerSet(2);
		game.setGameRules(gameRules);
		game.playGame();
	}
}

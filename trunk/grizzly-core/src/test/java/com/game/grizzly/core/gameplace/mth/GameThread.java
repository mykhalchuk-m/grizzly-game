package com.game.grizzly.core.gameplace.mth;

import java.util.ArrayList;
import java.util.List;

import com.game.grizzly.core.gameplace.SkillsGenerator;
import com.game.grizzly.core.gameplace.game.Game;
import com.game.grizzly.core.gameplace.game.GameRules;
import com.game.grizzly.core.gameplace.player.Player;

public class GameThread implements Runnable {

	private Game game;
	
	public GameThread() {
		SkillsGenerator skillsGenerator = new SkillsGenerator();

		Player player1 = new Player();
		player1.setName("player1");
		player1 = skillsGenerator.getnerateServes(player1);
		player1 = skillsGenerator.generateServesAcceptence(player1);
		player1 = skillsGenerator.generatePasive(player1);
		player1 = skillsGenerator.generateStrikes(player1);
		player1 = skillsGenerator.generateDefences(player1);

		Player player2 = new Player();
		player2.setName("player2");
		player2 = skillsGenerator.getnerateServes(player2);
		player2 = skillsGenerator.generateServesAcceptence(player2);
		player2 = skillsGenerator.generatePasive(player2);
		player2 = skillsGenerator.generateStrikes(player2);
		player2 = skillsGenerator.generateDefences(player2);

		List<Player> players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);

		game = new Game();
		GameRules gameRules = new GameRules();
		game.setPlayers(players);
		
		gameRules.setMatchCount(5);
		gameRules.setMaxScore(11);
		gameRules.setServesPerSet(2);
		game.setGameRules(gameRules);
	}
	
	@Override
	public void run() {
		game.playGame();
	}

}

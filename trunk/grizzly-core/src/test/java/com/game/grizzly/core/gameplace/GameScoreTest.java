package com.game.grizzly.core.gameplace;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.game.grizzly.core.gameplace.game.GameScore;
import com.game.grizzly.core.gameplace.match.MatchScore;
import com.game.grizzly.core.gameplace.player.Player;

public class GameScoreTest {
	
	private Player player1, player2;
	private GameScore gameScore = new GameScore();
	
	@Test
	public void init() {
		player1 = new Player();
		player1.setName("player1");
		player2 = new Player();
		player2.setName("player2");
		
		MatchScore matchScore1 = new MatchScore();
		matchScore1.incScore(player1, 1);
		matchScore1.incScore(player2, 1);
		matchScore1.incScore(player2, 1);
		matchScore1.incScore(player2, 1);
		matchScore1.incScore(player1, 1);
		
		MatchScore matchScore2 = new MatchScore();
		matchScore2.incScore(player1, 1);
		matchScore2.incScore(player1, 1);
		matchScore2.incScore(player1, 1);
		matchScore2.incScore(player1, 1);
		matchScore2.incScore(player2, 1);
		
		MatchScore matchScore3 = new MatchScore();
		matchScore3.incScore(player1, 1);
		matchScore3.incScore(player1, 1);
		matchScore3.incScore(player2, 1);
		matchScore3.incScore(player1, 1);
		matchScore3.incScore(player2, 1);
		
		MatchScore matchScore4 = new MatchScore();
		matchScore4.incScore(player2, 1);
		matchScore4.incScore(player2, 1);
		matchScore4.incScore(player1, 1);
		matchScore4.incScore(player1, 1);
		matchScore4.incScore(player2, 1);
		
		MatchScore matchScore5 = new MatchScore();
		matchScore5.incScore(player2, 1);
		matchScore5.incScore(player1, 1);
		matchScore5.incScore(player1, 1);
		matchScore5.incScore(player1, 1);
		matchScore5.incScore(player2, 1);
		
		Map<Integer, MatchScore> map = new HashMap<Integer, MatchScore>();
		int i=0;
		map.put(i++, matchScore1);
		map.put(i++, matchScore2);
		map.put(i++, matchScore3);
		map.put(i++, matchScore4);
		map.put(i++, matchScore5);
		
		i=0;
		gameScore.addMatchScore(matchScore1, i++);
		gameScore.addMatchScore(matchScore2, i++);
		gameScore.addMatchScore(matchScore3, i++);
		gameScore.addMatchScore(matchScore4, i++);
		gameScore.addMatchScore(matchScore5, i++);
		
		Assert.assertEquals(player1, gameScore.getWinner());
	}

}

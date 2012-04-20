package com.game.grizzly.core.gameplace;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.game.grizzly.core.gameplace.match.MatchScore;
import com.game.grizzly.core.gameplace.player.Player;

public class MatchScoreTest {
	
	private Player player1, player2;
	
	@Before
	public void init() {
		player1 = new Player();
		player1.setName("player1");
		player2 = new Player();
		player2.setName("player2");
	}
	
	@Test
	public void testIncScore() {
		Map<Player, Integer> map = new HashMap<Player, Integer>();
		map.put(player1, 1);
		
		MatchScore score = new MatchScore();
		score.incScore(player1, 1);
		
		Assert.assertEquals(map, score.getScore());
	}
	
	@Test
	public void testWinner() {
		MatchScore score = new MatchScore();
		score.incScore(player2, 1);
		score.incScore(player2, 1);
		score.incScore(player1, 1);
		score.incScore(player2, 1);
		score.incScore(player2, 1);
		
		Assert.assertEquals(player2, score.getWinner());
	}
}

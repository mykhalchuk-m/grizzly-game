package com.game.grizzly.core.gameplace.game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.game.grizzly.core.gameplace.match.MatchScore;
import com.game.grizzly.core.gameplace.player.Player;

public class GameScore {
	private Map<Integer, MatchScore> score;

	public GameScore() {
		score = new HashMap<Integer, MatchScore>();
	}

	public void addMatchScore(MatchScore matchScore, int matchPosition) {
		score.put(matchPosition, matchScore);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Game Score: \n");
		for (Integer i : score.keySet()) {
			builder.append(i);
			builder.append(": ");
			builder.append(score.get(i));
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public Player getWinner() {
		Map<Player, Integer> map = new HashMap<Player, Integer>();
		Set<Player> winners = new HashSet<Player>();
		for (Integer i : score.keySet()) {
			winners.add(score.get(i).getWinner());
		}
		
		for (Player player : winners) {
			if (!map.containsKey(player)) {
				map.put(player, 1);
			} else {
				map.put(player, map.get(player) + 1);
			}
		}
		
		Player winner = winners.iterator().next();
		for (Player player : map.keySet()) {
			if (map.get(winner) < map.get(player)) {
				winner = player;
			}
		}
		
		return winner;
	}
}

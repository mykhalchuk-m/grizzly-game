package com.game.grizzly.core.gameplace.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
		
		for (MatchScore matchScore : score.values()) {
			Player player = matchScore.getWinner();
			if (!map.containsKey(player)) {
				map.put(player, 1);
			} else {
				map.put(player, map.get(player) + 1);
			}
		}
		
		Entry<Player, Integer> winnerEntry = map.entrySet().iterator().next(); 
		Player winner = winnerEntry.getKey();
		int winnerPoints = winnerEntry.getValue();
		for(Entry<Player, Integer> entry: map.entrySet()) {
			if (entry.getValue() > winnerPoints) {
				winner = entry.getKey();
			}
		}
		
		return winner;
	}
}

package com.game.grizzly.core.gameplace.match;

import java.util.HashMap;
import java.util.Map;

import com.game.grizzly.core.gameplace.player.Player;

public class MatchScore {
	private Map<Player, Integer> score;

	public MatchScore() {
		score = new HashMap<Player, Integer>();
	}

	public Map<Player, Integer> getScore() {
		return score;
	}

	public Integer getScore(Player player) {
		return score.get(player);
	}

	public void incScore(Player player, int incValue) {
		Integer curentValue = score.get(player);
		if (null == curentValue) {
			score.put(player, incValue);
		} else {
			score.put(player, curentValue + incValue);
		}
	}
	
	public Player getWinner() {
		Player winner = score.keySet().iterator().next();
		for (Player player : score.keySet()) {
			if (score.get(winner) < score.get(player)) {
				winner = player;
			}
		}
		return winner;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (Player player : score.keySet()) {
			builder.append(player.getName());
			builder.append(" -> ");
			builder.append(score.get(player));
			builder.append("; ");
		}
		builder.append("]");
		return builder.toString();
	}
}

package com.game.grizzly.core.gameplace;

import java.util.ArrayList;
import java.util.List;

public class Score {
	/**
	 * score contains array that describes score of each player in clear order
	 */
	private List<Integer> score;

	public Score() {
		score = new ArrayList<Integer>();
	}

	public List<Integer> getScore() {
		return score;
	}

	public void incSrore(int player) {
		score.set(player, score.get(player) + 1);
	}
}

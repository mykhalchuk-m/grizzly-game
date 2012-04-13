package com.game.grizzly.core.gameplace;

import java.util.Arrays;

public class Rules {
	private int maxScore;
	private int servesPerSet;

	public boolean isFinish(Score score) {
		for (Integer count : score.getScore()) {
			if (count >= maxScore) {
				Integer[] scores = score.getScore().toArray(new Integer[0]);
				Arrays.sort(scores);
				if ((scores[0] - scores[1]) > 1) {
					return true;
				}
			}
		}
		return false;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public int getServesPerSet() {
		return servesPerSet;
	}

	public void setServesPerSet(int servesPerSet) {
		this.servesPerSet = servesPerSet;
	}
}

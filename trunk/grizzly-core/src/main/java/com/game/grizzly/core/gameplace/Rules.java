package com.game.grizzly.core.gameplace;

import java.util.Arrays;

public class Rules {
	private int maxScore;
	private int servesPerSet;

	public boolean isFinish(int... scores) {
		for (Integer count : scores) {
			if (count >= maxScore) {
				int[] temp = scores.clone();
				Arrays.sort(temp);
				if ((temp[1] - temp[0]) > 1) {
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

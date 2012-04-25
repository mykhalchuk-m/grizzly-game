package com.game.grizzly.core.gameplace.match;

import java.util.Arrays;
import java.util.Collection;

public class MatchRules {
	private int maxScore;
	private int servesPerSet;

	public boolean isFinish(Collection<Integer> scores) {
		for (Integer count : scores) {
			if (count >= maxScore) {
				if (scores.size() == 1) {
					return true;
				}
				Integer[] temp = scores.toArray(new Integer[0]);
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

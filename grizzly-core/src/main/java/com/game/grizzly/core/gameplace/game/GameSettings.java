package com.game.grizzly.core.gameplace.game;

public class GameSettings {
	private int matchCount;
	private int maxScore;
	private int servesPerSet;
	
	public int getMatchCount() {
		return matchCount;
	}

	public void setMatchCount(int matchCount) {
		this.matchCount = matchCount;
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

package com.game.grizzly.core.gameplace.game;

import com.game.grizzly.core.gameplace.match.MatchRules;

public class GameRules extends MatchRules {
	private int matchCount;

	public int getMatchCount() {
		return matchCount;
	}

	public void setMatchCount(int matchCount) {
		this.matchCount = matchCount;
	}
}

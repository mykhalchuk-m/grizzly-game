package com.game.grizzly.core.gameplace;

import java.util.List;

public class Match {
	private List<Player> players;
	private MatchState matchState;
	private Score score;
	
	public void playMatch() {
		score = new Score();
		System.out.println("play match..");
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public MatchState getMatchState() {
		return matchState;
	}

	public void setMatchState(MatchState matchState) {
		this.matchState = matchState;
	}

	public Score getMatchScore() {
		return score;
	}

	public void setMatchScore(Score matchScore) {
		this.score = matchScore;
	}

}

package com.game.grizzly.core.gameplace;

import java.util.List;

public class Game {
	private List<Match> matchs;

	private List<Player> players;

	public List<Match> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
}

package com.grezlee.game.actors;

import java.util.List;

public class Team {
	private String name;
	private List<Player> players;

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

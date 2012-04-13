package com.game.grizzly.core.gameplace;

import java.util.Random;

import com.game.grizzly.core.skill.serves.ServeType;

public class ServedPlayer {
	private Player player;
	private static Random random = new Random();

	public ServedPlayer(Player player) {
		this.player = player;
	}

	public ServeType getServeType() {
		return ServeType.values()[random.nextInt(ServeType.values().length)];
	}

	public int getServe(ServeType serveType) {
		return player.getServe(serveType).doAction();
	}
}

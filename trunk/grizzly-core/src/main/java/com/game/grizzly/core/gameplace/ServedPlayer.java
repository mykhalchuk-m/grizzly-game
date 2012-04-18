package com.game.grizzly.core.gameplace;

import java.util.Random;

import org.apache.log4j.Logger;

import com.game.grizzly.core.skill.passive.PasiveSkillType;
import com.game.grizzly.core.skill.serves.ServeType;

public class ServedPlayer {
	private Logger logger = Logger.getLogger(getClass());

	private Player player;
	private static Random random = new Random();

	public ServedPlayer(Player player) {
		this.player = player;
	}

	public ServeType getServeType() {
		return ServeType.values()[random.nextInt(ServeType.values().length)];
	}

	/**
	 * return 0 means that served player fell on his serve. This value affect
	 * success of serve.
	 */
	public double getServe(ServeType serveType) {
		if (random.nextDouble() > player.getPasives().get(PasiveSkillType.STAMINA).doAction()) {
			logger.info("Serve fall!!!");
			return 0;
		}
		return player.getServe(serveType).doAction();
	}

	public Player getPlayer() {
		return player;
	}
}

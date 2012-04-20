package com.game.grizzly.core.gameplace.player;

import java.util.Random;

import org.apache.log4j.Logger;

import com.game.grizzly.core.skill.serveacceptances.ServeAcceptenceType;
import com.game.grizzly.core.skill.serves.ServeType;

public class AcceptencePlayer {
	private Player player;
	private static Random random = new Random();
	private final Logger logger = Logger.getLogger(getClass());

	public AcceptencePlayer(Player player) {
		this.player = player;
	}

	public boolean canServeAcceptence(double serveValue, ServeType serveType) {
		double accepteValue = player.getServesAcceptence(ServeAcceptenceType.valueOf(serveType.toString())).doAction();
		double n = accepteValue / (accepteValue + serveValue);
		logger.info(player.getName() + " can accepte the serve with posibility: " + n);
		if (random.nextDouble() <= n) {
			logger.info("Serve accepted.");
			return true;
		}
		logger.info("Serve isn't accepted.");
		return false;
	}

	public Player getPlayer() {
		return player;
	}

}

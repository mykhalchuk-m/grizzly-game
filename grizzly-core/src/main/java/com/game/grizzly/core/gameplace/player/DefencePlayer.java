package com.game.grizzly.core.gameplace.player;

import java.util.Random;

import org.apache.log4j.Logger;

import com.game.grizzly.core.skill.defence.DefenceType;
import com.game.grizzly.core.skill.strike.StrikeType;

public class DefencePlayer {
	private Logger logger = Logger.getLogger(getClass());
	private Player player;
	
	private static Random random = new Random();

	public DefencePlayer(Player player) {
		this.player = player;
	}

	public boolean canDefence(double strikeValue, StrikeType strikeType) {
		double defenceVaue = player.getDefence(DefenceType.valueOf(strikeType.toString())).doAction();
		double n = defenceVaue / (defenceVaue + strikeValue);
		logger.info(player.getName() + " can defence the strike with posibility: " + n);
		if (random.nextDouble() <= n) {
			logger.info("Strike defenced.");
			return true;
		}
		logger.info("Strike isn't defended.");
		return false;
	}

	public Player getPlayer() {
		return this.player;
	}
}

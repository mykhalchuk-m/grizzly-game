package com.game.grizzly.core.gameplace;

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

	public boolean canDefence(int StrikeValue, StrikeType strikeType) {
		logger.info("Strike defence.");
		int defenceVaue = player.getDefence(DefenceType.valueOf(strikeType.toString())).doAction();
		int n = (int) Math.round((defenceVaue * 1.0 / (defenceVaue + StrikeValue)) * 100);
		logger.info("Strike defence posibility: " + n);
		if (random.nextInt(100) <= n) {
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

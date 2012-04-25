package com.game.grizzly.core.gameplace.player;

import java.util.Random;

import org.apache.log4j.Logger;

import com.game.grizzly.core.skill.passive.PasiveSkillType;
import com.game.grizzly.core.skill.strike.StrikeType;

public class StrikePlayer {
	private Player player;
	
	private final Logger logger = Logger.getLogger(getClass());
	private static Random random = new Random();
	private static final double DECREASE_STAMINA_VALUE = 0.01;
	private static final int MAX_PERCENT_VALUE = 100;

	public StrikePlayer(Player player) {
		this.player = player;
	}

	public StrikeType getStrikeType() {
		StrikeType strikeType = player.getPlayerSettings().getStrikeType();
		if (null == strikeType) {
			strikeType = StrikeType.values()[random.nextInt(StrikeType.values().length)];
		}
		return strikeType;
	}

	public double getStrike(StrikeType strikeType) {
		double critical = player.getPasives().get(PasiveSkillType.CRYTICAL_STRICE).doAction();
		double stikeValue = player.getStrike(strikeType).doAction();
		if (random.nextDouble() < critical) {
			stikeValue /= critical;
			logger.info("Critical strike: X" + (critical * MAX_PERCENT_VALUE) + " !!!!!!!!");
		}
		decStamina(DECREASE_STAMINA_VALUE);
		return stikeValue;
	}

	public Player getPlayer() {
		return this.player;
	}
	
	private void decStamina(double decValue) {
		double staminaValue = player.getPasiveSkill(PasiveSkillType.STAMINA).doAction();
		staminaValue -= decValue;
		logger.info(player.getName() + " stamina currently is -> " + staminaValue);
		player.getPasiveSkill(PasiveSkillType.STAMINA).setSkillValue(staminaValue);
	}
}

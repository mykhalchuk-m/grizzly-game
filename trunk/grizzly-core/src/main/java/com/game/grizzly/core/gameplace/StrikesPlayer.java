package com.game.grizzly.core.gameplace;

import java.util.Random;

import org.apache.log4j.Logger;

import com.game.grizzly.core.skill.passive.PasiveSkillType;
import com.game.grizzly.core.skill.strike.StrikeType;

public class StrikesPlayer {
	private Logger logger = Logger.getLogger(getClass());
	private Player player;
	private static Random random = new Random();

	public StrikesPlayer(Player player) {
		this.player = player;
	}

	public StrikeType getStrikeType() {
		return StrikeType.values()[random.nextInt(StrikeType.values().length)];
	}

	public int getStrike(StrikeType strikeType) {
		int critical = player.getPasives().get(PasiveSkillType.CRYTICAL_STRICE).doAction();
		int stikeValue = player.getStrike(strikeType).doAction();
		if (random.nextInt(100) < critical) {
			stikeValue *= critical;
			logger.info("Critical strike: " + critical + " !!!!!!!!");
		}
		decStamina(1);
		return stikeValue;
	}

	public Player getPlayer() {
		return this.player;
	}
	
	private void decStamina(int decValue) {
		logger.info("Stamina decreased by " + decValue);
		int staminaValue = player.getPasiveSkill(PasiveSkillType.STAMINA).doAction();
		staminaValue -= decValue;
		player.getPasiveSkill(PasiveSkillType.STAMINA).setSkillValue(staminaValue);
	}
}

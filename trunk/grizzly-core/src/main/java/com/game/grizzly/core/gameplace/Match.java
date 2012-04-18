package com.game.grizzly.core.gameplace;

import java.util.List;

import org.apache.log4j.Logger;

import com.game.grizzly.core.skill.serves.ServeType;
import com.game.grizzly.core.skill.strike.StrikeType;

public class Match {
	private Logger logger = Logger.getLogger(getClass());
	private static final int MAX_SCORE = 11;
	private static final int SERVES_PER_SET = 2;
	private static final int PUNKTS_PER_GOAL = 1;

	private List<Player> players;
	private Rules rules;

	private ServedPlayer servedPlayer;
	private AcceptencePlayer acceptencePlayer;

	private StrikePlayer strikePlayer;
	private DefencePlayer defencePlayer;

	private void initMatch() {
		logger.info("Before initialization.");
		servedPlayer = new ServedPlayer(players.get(0));
		acceptencePlayer = new AcceptencePlayer(players.get(1));
		rules = new Rules();
		rules.setMaxScore(MAX_SCORE);
		rules.setServesPerSet(SERVES_PER_SET);
		logger.info("Match initialized.");
	}

	public void playMatch() {
		for (initMatch(); !rules.isFinish(servedPlayer.getPlayer().getScore(), acceptencePlayer.getPlayer().getScore()); swapServes()) {
			
			logger.info("Set started. Set has " + rules.getServesPerSet() + " serves.");

			for (int i = 0; i < rules.getServesPerSet()
					&& !rules.isFinish(servedPlayer.getPlayer().getScore(), acceptencePlayer.getPlayer().getScore()); i++) {
				ServeType serveType = servedPlayer.getServeType();
				double serveValue = servedPlayer.getServe(serveType);

				if (serveValue == 0) {
					acceptencePlayer.getPlayer().incScore(PUNKTS_PER_GOAL);
					logScore(servedPlayer.getPlayer(), acceptencePlayer.getPlayer());
					continue;
				}

				logger.info("Choused serve: " + serveType);

				if (!acceptencePlayer.canServeAcceptence(serveValue, serveType)) {
					servedPlayer.getPlayer().incScore(PUNKTS_PER_GOAL);
				} else {
					logger.info("--------- game ---------");

					strikePlayer = new StrikePlayer(acceptencePlayer.getPlayer());
					defencePlayer = new DefencePlayer(servedPlayer.getPlayer());

					for (boolean goal = false; !goal; swapStrikers()) {
						StrikeType strikeType = strikePlayer.getStrikeType();
						logger.info("Choused strike: " + strikeType);
						if (!defencePlayer.canDefence(strikePlayer.getStrike(strikeType), strikeType)) {
							goal = true;
							strikePlayer.getPlayer().incScore(PUNKTS_PER_GOAL);
						}
					}
				}
				logScore(servedPlayer.getPlayer(), acceptencePlayer.getPlayer());
			}
		}
	}

	private void swapStrikers() {
		Player temp = strikePlayer.getPlayer();
		strikePlayer = new StrikePlayer(defencePlayer.getPlayer());
		defencePlayer = new DefencePlayer(temp);
	}

	private void swapServes() {
		Player temp = servedPlayer.getPlayer();
		servedPlayer = new ServedPlayer(acceptencePlayer.getPlayer());
		acceptencePlayer = new AcceptencePlayer(temp);
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	private void logScore(Player player1, Player player2) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Score: [");
		stringBuilder.append(player1.getName());
		stringBuilder.append(" -> ");
		stringBuilder.append(player1.getScore());
		stringBuilder.append("; ");
		stringBuilder.append(player2.getName());
		stringBuilder.append(" -> ");
		stringBuilder.append(player2.getScore());
		stringBuilder.append("]");
		logger.info(stringBuilder.toString());
	}
}

package com.game.grizzly.core.gameplace;

import java.util.List;

import org.apache.log4j.Logger;

import com.game.grizzly.core.skill.serves.ServeType;
import com.game.grizzly.core.skill.strike.StrikeType;

public class Match {
	private Logger logger = Logger.getLogger(getClass());

	private List<Player> players;
	private MatchState matchState;
	private Rules rules;

	private ServedPlayer servedPlayer;
	private AcceptencePlayer acceptencePlayer;

	private StrikesPlayer strikePlayer;
	private DefencePlayer defencePlayer;

	private void initMatch() {
		servedPlayer = new ServedPlayer(players.get(0));
		acceptencePlayer = new AcceptencePlayer(players.get(1));
		rules = new Rules();
		rules.setMaxScore(11);
		rules.setServesPerSet(2);
	}

	public void playMatch() {
		logger.info("Before initialization.");
		initMatch();
		logger.info("Match initialized.");
		while (!rules.isFinish(servedPlayer.getPlayer().getScore(), acceptencePlayer.getPlayer().getScore())) {
			logger.info("Set started. Set has " + rules.getServesPerSet() + " serves.");

			for (int i = 0; i < rules.getServesPerSet()
					&& !rules.isFinish(servedPlayer.getPlayer().getScore(), acceptencePlayer.getPlayer().getScore()); i++, swapServes()) {
				ServeType serveType = servedPlayer.getServeType();
				int serveValue = servedPlayer.getServe(serveType);
				if (serveValue == 0) {
					acceptencePlayer.getPlayer().incScore(1);
					logger.info("Score: " + servedPlayer.getPlayer().getScore() + " : "
							+ acceptencePlayer.getPlayer().getScore());
					break;
				}
				logger.info("Choused serve: " + serveType);

				if (!acceptencePlayer.canServeAcceptence(serveValue, serveType)) {
					servedPlayer.getPlayer().incScore(1);
				} else {
					logger.info("--------- game ---------");
					
					strikePlayer = new StrikesPlayer(acceptencePlayer.getPlayer());
					defencePlayer = new DefencePlayer(servedPlayer.getPlayer());
					
					for (boolean goal = false; !goal; swapStrikers()) {
						StrikeType strikeType = strikePlayer.getStrikeType();
						logger.info("Choused strike: " + strikeType);
						if (!defencePlayer.canDefence(strikePlayer.getStrike(strikeType), strikeType)) {
							goal = true;
							strikePlayer.getPlayer().incScore(1);
						}
					}
				}
				logger.info("Score: " + servedPlayer.getPlayer().getScore() + " : "
						+ acceptencePlayer.getPlayer().getScore());
			}
		}
	}

	private void swapStrikers() {
		Player temp = strikePlayer.getPlayer();
		strikePlayer = new StrikesPlayer(defencePlayer.getPlayer());
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

	public MatchState getMatchState() {
		return matchState;
	}

	public void setMatchState(MatchState matchState) {
		this.matchState = matchState;
	}
}

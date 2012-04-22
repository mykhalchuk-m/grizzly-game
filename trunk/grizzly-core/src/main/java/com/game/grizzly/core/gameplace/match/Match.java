package com.game.grizzly.core.gameplace.match;

import java.util.List;

import org.apache.log4j.Logger;

import com.game.grizzly.core.gameplace.player.AcceptencePlayer;
import com.game.grizzly.core.gameplace.player.DefencePlayer;
import com.game.grizzly.core.gameplace.player.Player;
import com.game.grizzly.core.gameplace.player.ServedPlayer;
import com.game.grizzly.core.gameplace.player.StrikePlayer;
import com.game.grizzly.core.skill.serves.ServeType;
import com.game.grizzly.core.skill.strike.StrikeType;
import com.game.grizzly.core.statistic.SuccessType;

public class Match {
	private Logger logger = Logger.getLogger(getClass());
	private static final int PUNKTS_PER_GOAL = 1;

	private List<Player> players;
	private MatchRules rules;

	private ServedPlayer servedPlayer;
	private AcceptencePlayer acceptencePlayer;

	private StrikePlayer strikePlayer;
	private DefencePlayer defencePlayer;

	private void initMatch() {
		logger.info("Before initialization.");
		servedPlayer = new ServedPlayer(players.get(0));
		acceptencePlayer = new AcceptencePlayer(players.get(1));
		logger.info("Match initialized.");
	}

	/**
	 * Plays match with rules between all players, after returns winner
	 */
	public MatchScore playMatch() {
		MatchScore matchScore = new MatchScore();
		
		for (initMatch(); !getRules().isFinish(matchScore.getScore().values()); swapServes()) {

			logger.info("Set started. Set has " + getRules().getServesPerSet() + " serves.");

			for (int i = 0; i < getRules().getServesPerSet()
					&& !getRules().isFinish(matchScore.getScore().values()); i++) {
				ServeType serveType = servedPlayer.getServeType();
				logger.info(servedPlayer.getPlayer().getName() + " serves with " + serveType);
				
				double serveValue = servedPlayer.getServe(serveType);
				if (serveValue == 0) {
					matchScore.incScore(acceptencePlayer.getPlayer(), PUNKTS_PER_GOAL);
					servedPlayer.getPlayer().getStatistics().registerServeAs(serveType, SuccessType.UNSUCCESS);
					logger.info(matchScore);
					continue;
				} else {
					servedPlayer.getPlayer().getStatistics().registerServeAs(serveType, SuccessType.SUCCESS);
				}

				if (!acceptencePlayer.canServeAcceptence(serveValue, serveType)) {
					matchScore.incScore(servedPlayer.getPlayer(), PUNKTS_PER_GOAL);
				} else {
					logger.info("--------- game ---------");

					strikePlayer = new StrikePlayer(acceptencePlayer.getPlayer());
					defencePlayer = new DefencePlayer(servedPlayer.getPlayer());

					for (boolean goal = false; !goal; swapStrikers()) {
						StrikeType strikeType = strikePlayer.getStrikeType();
						logger.info(strikePlayer.getPlayer().getName() + " striks with " + strikeType);
						if (!defencePlayer.canDefence(strikePlayer.getStrike(strikeType), strikeType)) {
							goal = true;
							matchScore.incScore(strikePlayer.getPlayer(), PUNKTS_PER_GOAL);
						}
					}
					logger.info("------- end game -------");
				}
				logger.info(matchScore);
			}
		}
		return matchScore;
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

	public MatchRules getRules() {
		return rules;
	}

	public void setRules(MatchRules rules) {
		this.rules = rules;
	}
}

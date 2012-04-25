package com.game.grizzly.core.gameplace.game;

import java.util.List;

import org.apache.log4j.Logger;

import com.game.grizzly.core.gameplace.match.Match;
import com.game.grizzly.core.gameplace.match.MatchScore;
import com.game.grizzly.core.gameplace.player.Player;

public class Game {
	private final Logger logger = Logger.getLogger(getClass());

	private List<Match> matchs;
	private GameScore gameScore;
	private GameRules gameRules;
	private List<Player> players;

	public Game() {
		gameScore = new GameScore();
	}
	
	public void playGame() {
		Match match = new Match();
		match.setPlayers(players);
		match.setRules(gameRules);
		for (int i = 0; i < gameRules.getMatchCount(); i++) {
			logger.info("============= match " + (i+1) + " ===========");
			MatchScore matchScore = match.playMatch();
			logger.info(match.getStatistics());
			gameScore.addMatchScore(matchScore, i);
		}
		logger.info(gameScore);
		logger.info("Game winner: " + gameScore.getWinner().getName());
	}
	
	

	public List<Match> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public GameScore getScore() {
		return gameScore;
	}

	public GameRules getGameRules() {
		return gameRules;
	}

	public void setGameRules(GameRules gameRules) {
		this.gameRules = gameRules;
	}
}

package com.grezlee.game.base;

import com.grezlee.game.actors.Team;

public class Game {
	private GameScore score;
	private Team[] teams;
	private GameStatus gameStatus;

	public void setScore(GameScore score) {
		this.score = score;
	}

	public GameScore getScore() {
		return score;
	}

	public void setTeams(Team[] teams) {
		this.teams = teams;
	}

	public Team[] getTeams() {
		return teams;
	}

	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}
}

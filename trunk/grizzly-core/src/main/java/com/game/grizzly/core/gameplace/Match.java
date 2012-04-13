package com.game.grizzly.core.gameplace;

import java.util.List;

import com.game.grizzly.core.skill.serves.ServeType;

public class Match {
	private List<Player> players;
	private MatchState matchState;
	private Score score;
	private Rules rules;

	private ServedPlayer servedPlayer;
	private AcceptencePlayer acceptencePlayer;

	private void initMatch() {
		servedPlayer = new ServedPlayer(players.get(0));
		acceptencePlayer = new AcceptencePlayer(players.get(1));
		score = new Score();
		rules.setMaxScore(11);
		rules.setServesPerSet(2);
	}

	public void playMatch() {
		initMatch();
		ServeType serveType = servedPlayer.getServeType();
		while (!rules.isFinish(score)) {
			for (int i = 0; i < rules.getServesPerSet(); i++) {
				if (acceptencePlayer.canServeAcceptence(
						servedPlayer.getServe(serveType), serveType)) {
					score.incSrore(0);
				} else {
					score.incSrore(1);
				}

			}
		}
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

	public Score getMatchScore() {
		return score;
	}

	public void setMatchScore(Score matchScore) {
		this.score = matchScore;
	}

}

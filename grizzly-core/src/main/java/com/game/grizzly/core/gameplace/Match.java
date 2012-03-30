package com.game.grizzly.core.gameplace;

import java.util.List;
import java.util.Random;

import com.game.grizzly.core.skills.SkillType;

public class Match {
	private List<Player> players;
	private MatchState matchState;
	private Score score;
	
	public void playMatch() {
		Random random = new Random();
		if (random.nextDouble() > players.get(0).getSkillValue(SkillType.PASIVE_STAMINA)) {
			score.incSrore(1);
		} else {
			
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

package com.grezlee.game.actors;

import java.util.List;

public class Player {
	int level;
	private List<Skill> skills;
	private List<Item> items;
	private PlayerState currentState;
	private Status status;

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setCurrentState(PlayerState currentState) {
		this.currentState = currentState;
	}

	public PlayerState getCurrentState() {
		return currentState;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}
}

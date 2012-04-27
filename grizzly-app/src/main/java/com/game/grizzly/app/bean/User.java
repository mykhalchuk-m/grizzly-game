package com.game.grizzly.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.game.grizzly.core.gameplace.player.Player;

@Entity
@Table(name = "user_tbl")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String name;
	@Transient
	private Player player;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

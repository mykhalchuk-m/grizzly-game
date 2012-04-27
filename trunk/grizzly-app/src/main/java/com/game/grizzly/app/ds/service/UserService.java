package com.game.grizzly.app.ds.service;

import com.game.grizzly.app.bean.User;

public interface UserService {
	User getUser(String name);

	void createUser(User user);
}

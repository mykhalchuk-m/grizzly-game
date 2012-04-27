package com.game.grizzly.app.ds.dao;

import com.game.grizzly.app.bean.User;

public interface UserDao extends GenericDao<User, Long>{
	User getUser(String name);
}

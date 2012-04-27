package com.game.grizzly.app.ds.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.game.grizzly.app.bean.User;
import com.game.grizzly.app.ds.dao.UserDao;
import com.game.grizzly.app.ds.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public User getUser(String name) {
		return userDao.getUser(name);
	}

	@Transactional
	public void createUser(User user) {
		userDao.create(user);
	}

}

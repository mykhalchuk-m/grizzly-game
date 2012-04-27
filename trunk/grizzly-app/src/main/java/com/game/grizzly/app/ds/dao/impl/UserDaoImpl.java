package com.game.grizzly.app.ds.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.game.grizzly.app.bean.User;
import com.game.grizzly.app.ds.dao.UserDao;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Long create(User user) {
		return (Long) sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User read(Long id) {
		Object o = sessionFactory.getCurrentSession().get(User.class, id);
		if (o instanceof User) {
			return (User) o;
		}
		return null;
	}

	@Override
	public void update(User t) {
		sessionFactory.getCurrentSession().update(t);
	}

	@Override
	public void delete(User t) {
		sessionFactory.getCurrentSession().delete(t);
	}

	@Override
	public User getUser(String name) {
		Object o = sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("name", name))
				.uniqueResult();
		if (o instanceof User) {
			return (User) o;
		}
		return null;
	}

}

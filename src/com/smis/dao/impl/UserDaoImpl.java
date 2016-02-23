package com.smis.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smis.dao.IUserDao;
import com.smis.model.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable save(User user) {
		return this.sessionFactory.getCurrentSession().save(user);
	}
	

}

package com.smis.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smis.dao.user.IUserDao;
import com.smis.model.User;
import com.smis.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public Serializable save(User user) {
		return userDao.save(user);
	}

	@Override
	public User get(String userId) {
		return userDao.get(userId);
	}

}

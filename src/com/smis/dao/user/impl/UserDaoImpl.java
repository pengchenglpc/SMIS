package com.smis.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.smis.dao.base.impl.BaseDaoImpl;
import com.smis.dao.user.IUserDao;
import com.smis.model.user.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {
	
}

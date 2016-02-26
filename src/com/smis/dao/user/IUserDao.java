package com.smis.dao.user;

import java.io.Serializable;

import com.smis.dao.base.IBaseDao;
import com.smis.model.User;

public interface IUserDao extends IBaseDao<User> {
	public Serializable save(User user);
}

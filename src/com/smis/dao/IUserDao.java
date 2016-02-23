package com.smis.dao;

import java.io.Serializable;

import com.smis.model.User;

public interface IUserDao {
	public Serializable save(User user);
}

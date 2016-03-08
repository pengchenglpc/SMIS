package com.smis.service.user.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smis.dao.user.IUserDao;
import com.smis.model.common.Result;
import com.smis.model.user.User;
import com.smis.service.user.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public Result login(String userId, String password) {
		Result result = new Result(1);
		User user = userDao.get(userId);
		if(user == null){
			result.setStatus(0);
			result.setMessage("账户不存在");
			return result;
		}
		if(user.getUserFlag() == 1){
			result.setStatus(0);
			result.setMessage("账户尚未启用，请联系管理员");
			return result;
		}
		if(!user.getPassword().equals(password)){
			result.setStatus(0);
			result.setMessage("密码与用户名不匹配");
			return result;
		}
		result.setData(user);
		return result;
	}


}

package com.smis.service.user;

import com.smis.model.common.Result;

public interface IUserService {
	public Result login(String userId, String password);

}

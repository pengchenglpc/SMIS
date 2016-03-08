package com.smis.action.user;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.smis.action.base.BaseAction;
import com.smis.common.util.CommonConstant;
import com.smis.model.common.Result;
import com.smis.model.user.User;
import com.smis.service.user.IUserService;

import net.sf.json.JSONObject;

public class UserAction extends BaseAction {
	private User user;
	
	@Autowired
	private IUserService userService;
	
	public void login() throws IOException{
		Result result = userService.login(user.getUserId(), user.getPassword());
		if(result.getStatus() == 1){
			session.put(CommonConstant.SESSION_LOGIN_KEY, result.getData());
		}
		outJSON(JSONObject.fromObject(result));
	}
}

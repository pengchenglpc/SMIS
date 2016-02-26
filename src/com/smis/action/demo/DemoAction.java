package com.smis.action.demo;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.smis.model.User;
import com.smis.service.IUserService;

@Controller("demoAction")
public class DemoAction {
	@Autowired
	private IUserService userService;
	public String add(){
		User user = new User();
		user.setId("test1");
		user.setName("这是一个测试");
		user.setPassword("test1");
		Serializable a = this.userService.save(user);
		return null;
	}
	public String get(){
		User user = userService.get("test1");
		System.out.println(user.getName());
		return null;
	}
	
}

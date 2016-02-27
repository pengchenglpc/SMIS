package com.smis.action.system;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.smis.action.base.BaseAction;
import com.smis.model.common.Result;
import com.smis.model.system.Menu;
import com.smis.service.system.IMenuService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller("menuAction")
public class MenuAction extends BaseAction {
	private Menu menu;
	
	@Autowired
	private IMenuService menuService;
	/**
	 * 添加菜单项
	 * @return
	 * @throws IOException 
	 */
	public void add() throws IOException{
		outJSON(JSONObject.fromObject(new Result(this.menuService.addMenu(menu) ? 1 : 0)));
		//return JSONObject.fromObject(new Result(this.menuService.addMenu(menu) ? 1 : 0)).toString();
	}
	
	/**
	 * 查询所有菜单项
	 * @return
	 * @throws IOException 
	 */
	public void findAll() throws IOException{
		outJSON(JSONArray.fromObject(this.menuService.findAll()));
		//return JSONArray.fromObject(this.menuService.findAll()).toString();
	}
}

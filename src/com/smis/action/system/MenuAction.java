package com.smis.action.system;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.smis.action.base.BaseAction;
import com.smis.common.util.CommonUtil;
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
		menu.setId(CommonUtil.id());
		outJSON(JSONObject.fromObject(new Result(this.menuService.addMenu(menu) ? 1 : 0)));
	}
	
	public void edit() throws IOException{
		int flag = 0;
		try{
			this.menuService.editMenu(menu);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		outJSON(JSONObject.fromObject(new Result(flag)));
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
	public void findParam() throws IOException{
		outJSON(JSONObject.fromObject(this.menuService.findMenu(menu)));
	}
	
	public void findTree() throws IOException{
		outJSON(JSONObject.fromObject(this.menuService.findMenu(null)));
	}
	
	public void findRoot() throws IOException{
		outJSON(JSONArray.fromObject(this.menuService.findRootMenu()));
	}
	
	public void findParent() throws IOException{
		outJSON(JSONArray.fromObject(this.menuService.findParentMenu(menu.getMenuParent())));
	}
	public void remove() throws IOException{
		int flag = 0;
		try{
			this.menuService.removeMenu(menu);
			flag = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		outJSON(JSONObject.fromObject(new Result(flag)));
	}
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
}

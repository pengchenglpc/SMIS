package com.smis.service.system;

import java.util.List;

import com.smis.model.system.Menu;

public interface IMenuService {
	
	/**
	 * 添加菜单项
	 * @param menu
	 * @return
	 */
	public boolean addMenu(Menu menu);
	
	/**
	 * 查询所有菜单项
	 * @return
	 */
	public List<Menu> findAll();
	
	/**
	 * 根据条件查询菜单
	 * @param menu
	 * @return
	 */
	public List<Menu> findMenu(Menu menu);
}

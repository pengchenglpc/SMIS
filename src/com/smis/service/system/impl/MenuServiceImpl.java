package com.smis.service.system.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smis.common.util.CommonUtil;
import com.smis.dao.system.IMenuDao;
import com.smis.model.common.Page;
import com.smis.model.system.Menu;
import com.smis.service.system.IMenuService;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {
	
	@Autowired
	private IMenuDao menuDao;
	@Override
	public boolean addMenu(Menu menu) {
		String id = CommonUtil.id();
		menu.setId(id);
		//设置菜单创建时间
		menu.setCreateTime(CommonUtil.dateFormat(CommonUtil.getCurrentDate()));
		//设置菜单更新时间
		menu.setUpdateTime(CommonUtil.dateFormat(CommonUtil.getCurrentDate()));
		Serializable entityId = this.menuDao.save(menu);
		return id.equals(entityId);
	}
	
	@Override
	public List<Menu> findAll() {
		List<Menu> list = menuDao.findAll();
		return list;
	}

	@Override
	public Page<Menu> findMenu(Menu menu) {
		Page<Menu> page = new Page<Menu>();
		List<Menu> rows = null;
		if(menu == null){
			rows = menuDao.findAll();
		}else{
			rows = menuDao.findMenu(menu);
		}
		page.setTotal(rows.size());
		page.setRows(rows);
		return page;
	}

	@Override
	public void removeMenu(Menu menu) {
		menuDao.delete(menu);
	}

	@Override
	public void editMenu(Menu menu) {
		Menu _menu = menuDao.get(menu.getId());
		
		menu.setCreateTime(_menu.getCreateTime());
		menu.setCreator(_menu.getCreator());
		menu.setUpdateTime(CommonUtil.dateFormat(CommonUtil.getCurrentDate()));
		menuDao.update(menu);
	}

	@Override
	public List<Menu> findRootMenu() {
		return menuDao.findRootMenu();
	}

	@Override
	public List<Menu> findParentMenu(String parentId) {
		Menu menu = new Menu();
		menu.setMenuParent(parentId);
		
		return menuDao.findMenu(menu);
	}

}

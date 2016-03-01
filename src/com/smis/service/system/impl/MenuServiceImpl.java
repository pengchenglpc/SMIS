package com.smis.service.system.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smis.common.util.CommonUtil;
import com.smis.dao.system.IMenuDao;
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
	public List<Menu> findMenu(Menu menu) {
		return menuDao.findMenu(menu);
	}

}

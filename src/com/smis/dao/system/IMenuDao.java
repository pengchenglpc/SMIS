package com.smis.dao.system;

import java.util.List;

import com.smis.dao.base.IBaseDao;
import com.smis.model.system.Menu;

public interface IMenuDao extends IBaseDao<Menu> {
	public List<Menu> findMenu(Menu menu);
	
	public List<Menu> findRootMenu();
}

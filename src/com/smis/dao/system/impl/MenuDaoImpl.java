package com.smis.dao.system.impl;

import org.springframework.stereotype.Repository;

import com.smis.dao.base.impl.BaseDaoImpl;
import com.smis.dao.system.IMenuDao;
import com.smis.model.system.Menu;

@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl<Menu>implements IMenuDao {
	
}

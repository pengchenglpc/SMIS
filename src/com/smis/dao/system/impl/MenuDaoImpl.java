package com.smis.dao.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.smis.dao.base.impl.BaseDaoImpl;
import com.smis.dao.system.IMenuDao;
import com.smis.model.system.Menu;

@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl<Menu>implements IMenuDao {

	@Override
	public List<Menu> findMenu(Menu menu) {
		StringBuilder query = new StringBuilder();
		Map<String, Object> queryParam = new HashMap<String, Object>();
		query.append("from Menu");
		query.append(" where 1=1 ");
		if(!StringUtils.isEmpty(menu.getId())){
			query.append(" and id=:id");
			queryParam.put("id", menu.getId());
		}
		if(!StringUtils.isEmpty(menu.getMenuParent())){
			query.append(" and menuParent=:menuParent");
			queryParam.put("menuParent", menu.getMenuParent());
		}
		if(!StringUtils.isEmpty(menu.getMenuName())){
			query.append(" and menuName like '%:menuName%'");
			queryParam.put("menuName", menu.getMenuName());
		}
		
		query.append(" order by sort desc");
		return this.findQuery(query.toString(), queryParam);
	}

	@Override
	public List<Menu> findRootMenu() {
		StringBuilder query = new StringBuilder();
		query.append("from Menu where menuParent is null or menuParent='' order by sort desc");
		return this.findQuery(query.toString());
	}
	
}

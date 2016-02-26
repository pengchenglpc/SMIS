package com.smis.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smis.dao.base.IBaseDao;
import com.smis.model.common.Page;

@Repository("baseDao")
public class BaseDaoImpl<T> implements IBaseDao<T> {
	@Autowired
	private SessionFactory sessionFactory;
	
	//private Class<T> clazz;
	
	private Class getClazz(){
		Type genType = getClass().getGenericSuperclass();  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
        return (Class) params[0];
	}
	@Override
	public Serializable save(T entity) {
		return sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public T get(Serializable id) {
		@SuppressWarnings("unchecked")
		T entity = (T)sessionFactory.getCurrentSession().get(this.getClazz(), id);
		return entity;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findQuery(String querySql) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(querySql);
		List<T> data = query.list();
		return data;
	}
	@Override
	public Page<T> findPageQuery(String querySQL, Integer page, Integer pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(querySQL);
		query.setFirstResult((page - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		Page<T> pages = new Page<T>();
		pages.setPage(page);
		pages.setPageSize(pageSize);
		pages.setRows(query.list());
		return pages;
	}
	
	private Integer getCount(String querySQL){
		String queryCountQuery = "SELECT COUNT(*)";
		if(querySQL.indexOf("select") >= 0 || querySQL.indexOf("SELECT") >= 0){
			int index = querySQL.indexOf("from") >= 0 ? querySQL.indexOf("from") : querySQL.indexOf("FROM");   
			querySQL = querySQL.substring(index);
		}
		queryCountQuery += querySQL;
		return 0;
	}
}

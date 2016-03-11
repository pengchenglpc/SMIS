package com.smis.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
		Session session = sessionFactory.getCurrentSession();
		session.clear();
		session.update(entity);
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
		pages.setTotal(getCount(querySQL));
		return pages;
	}
	
	private Integer getCount(String querySQL){
		String queryCountQuery = "SELECT COUNT(*)";
		if(querySQL.indexOf("select") >= 0 || querySQL.indexOf("SELECT") >= 0){
			int index = querySQL.indexOf("from") >= 0 ? querySQL.indexOf("from") : querySQL.indexOf("FROM");   
			querySQL = querySQL.substring(index);
		}
		queryCountQuery += querySQL;
		
		Query query = sessionFactory.getCurrentSession().createQuery(queryCountQuery);
		return (Integer)query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findQuery(String querySQL, Map<String, Object> param) {
		Query query = sessionFactory.getCurrentSession().createQuery(querySQL);
		for(String key : param.keySet()){
			query.setParameter(key, param.get(key));
		}
		return query.list();
	}
	@Override
	public Page<T> findPageQuery(String querySQL, Map<String, Object> param, Integer page, Integer pageSize) {
		Query query = sessionFactory.getCurrentSession().createQuery(querySQL);
		for(String key : param.keySet()){
			query.setParameter(key, param.get(key));
		}
		query.setFirstResult((page - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		Page<T> pager = new Page<T>();
		pager.setRows(query.list());
		pager.setPage(page);
		pager.setPageSize(pageSize);
		return pager;
	}
	
	@Override
	public Integer getTotalCount(String querySQL, Map<String, Object> param) {
		Query query = sessionFactory.getCurrentSession().createQuery(querySQL);
		for(String key : param.keySet()){
			query.setParameter(key, param.get(key));
		}
		Integer total = (Integer)query.list().get(0);
		return total;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(this.getClazz());
		//criteria.addOrder(Order.desc("sort"));
		return criteria.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<T> findAll(Integer page, Integer pageSize) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(this.getClazz());
		Integer rowCount = (Integer) criteria.setProjection(
				Projections.rowCount()).uniqueResult();
		
		criteria.setFirstResult((page - 1) * pageSize);
		criteria.setMaxResults(pageSize);
		
		Page<T> pager = new Page<T>();
		pager.setTotal(rowCount);
		pager.setPage(page);
		pager.setPageSize(pageSize);
		pager.setRows(criteria.list());
		
		return pager;
	}
	@Override
	public List findQueryNoCast(String querySQL, Map<String, Object> param) {
		Query query = sessionFactory.getCurrentSession().createQuery(querySQL);
		if(param != null){
			for(String key : param.keySet()){
				query.setParameter(key, param.get(key));
			}
		}
		return query.list();
	}
}

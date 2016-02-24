package com.smis.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.smis.dao.base.IBaseDao;

@Repository("baseDao")
public class BaseDaoImpl<T> implements IBaseDao<T> {
	@Autowired
	private SessionFactory sessionFactory;
	
	//private Class<T> clazz;
	
	public Class getClazz(){
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

}

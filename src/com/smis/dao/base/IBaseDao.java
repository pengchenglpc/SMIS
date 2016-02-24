package com.smis.dao.base;

import java.io.Serializable;

public interface IBaseDao<T> {
	/**
	 * 新增实体
	 * @param entity
	 * @return
	 */
	public Serializable save(T entity);
	
	/**
	 * 	修改实体
	 * @param entity
	 */
	public void update(T entity);
	
	/**
	 * 删除实体
	 * @param entity
	 */
	public void delete(T entity);
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	public T get(Serializable id);
	
}

package com.smis.dao.base;

import java.io.Serializable;
import java.util.List;

import com.smis.model.common.Page;

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
	
	/**
	 * 根据HQL语句查询数据
	 * @param whereQuery
	 * @return
	 */
	public List<T> findQuery(String querySQL);
	
	/**
	 * 
	 * @param querySQL HQL查询语句
	 * @param page	当面页
	 * @param pageSize 每页显示条数
	 * @return
	 */
	public Page<T> findPageQuery(String querySQL, Integer page, Integer pageSize);
	
}

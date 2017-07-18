package com.opslab.workflow.framework.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.opslab.workflow.framework.entity.Page;
import com.opslab.workflow.framework.exception.DataAccessException;


/**
 * 业务实例的DAO层的操作API定义接口
 * 注意此处的方法都通过entry标识也操作属于DAO层
 * 泛型说明
 * 		T	业务实体类型
 * 		ID	业务实体主键类型
 *
 */
public interface SupportDao<T,ID extends Serializable> {
	/**
	 * 返回一个count语句的查询结果
	 * @param hql
	 * @param params
	 * @throws DataAccessException
     */
	public int count(String hql, Object... params) throws DataAccessException;

	/**
	 * 返回一个非count语句的记录总数
	 * @param hql
	 * @param params
	 * @throws DataAccessException
     */
	public int countCommon(String hql, Object... params) throws DataAccessException;

	/**
	 * 保存实体
	 * @param t
	 * @throws DataAccessException
     */
	public void save(T t) throws DataAccessException;

	/**
	 * 更新实体
	 * @param t
	 * @throws DataAccessException
     */
	public void update(T t) throws DataAccessException;

	/**
	 * 保存货更新
	 * @param t
	 * @throws DataAccessException
     */
	public void saveOrUpdate(T t) throws DataAccessException;

	/**
	 * 删除实体
	 * @param t
	 * @throws DataAccessException
     */
	public void delete(T t) throws DataAccessException;

	/**
	 * 删除实体
	 * @param id
	 * @throws DataAccessException
     */
	public void deleteById(ID id) throws DataAccessException;

	/**
	 * 删除实体
	 * @param entities
	 * @throws DataAccessException
     */
	public void deleteAll(Collection<T> entities) throws DataAccessException;

	/**
	 * 加载实体
	 * @param id
	 * @return
	 * @throws DataAccessException
     */
	public T load(ID id) throws DataAccessException;


	/**
	 * 加载实体
	 * @param id
	 * @return
	 * @throws DataAccessException
     */
	public T get(ID id) throws DataAccessException;



	/**
	 * 使用HQL获得实体列表
	 * @param hql
	 * @return
	 * @throws DataAccessException
	 */
	public List<T> query(String hql, Object... params) throws DataAccessException;



	/**
	 * 通过HQL查询单个实体
	 * @param hql
	 * @param params
	 * @return
	 * @throws DataAccessException
     */
	public T queryFirst(String hql, Object... params) throws DataAccessException;

	/**
	 * 通过HQL查询单个实体
	 * @param hql
	 * @param params
	 * @return
	 * @throws DataAccessException
     */
	public T queryLast(String hql, Object... params) throws DataAccessException;


	/**
	 * 查询分页
	 * @param hql 查询的hql语句
	 * @param page 当前页
	 * @param size 当前页数
	 * @param params hql的参数
	 * @return 一个分页对象
	 * @throws DataAccessException
     */
	public Page page(String hql, int page, int size, Object... params) throws DataAccessException;
}

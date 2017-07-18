package app.dao;

import app.entries.EntryPage;
import app.exception.DataAccessException;

import java.util.List;


/**
 * @summary:
 * 		业务实例的DAO层的操作API定义接口
 * 
 *    注意此处的方法都通过entry标识也操作属于DAO层
 *
 */
public interface SupportDao<T> {
	
	//保存实体
	public void saveEntry(T t) throws DataAccessException;
	
	//更新实体
	public void updateEntry(T t) throws DataAccessException;
	
	//保存或更新
	public void saveOrUpdateEntry(T t) throws DataAccessException;
	
	//删除实体
	public void deleteEntryById(T t) throws DataAccessException;
	
	//加载实体
	public T loadEntry(Integer id) throws DataAccessException;
	
	//加载实体
	public T getEntry(Integer id) throws DataAccessException;
	
	//通过HQL查询单个实体
	public T queryEntry(String hql) throws DataAccessException;
	
	//以HQL方式批量操作
	public int batchEntryByHQL(String hql,Object ...objects) throws DataAccessException;
	
	//通过HQL获得实体列表
	public List<T> getEntryListByHQL(String hql,Object ...objects) throws DataAccessException;
	
	//通过SQL获得提示列表
	public List<T> getEntryListBySQL(String sql,Object ...objects) throws DataAccessException;

	//通过HQL获取实例列表
	public List<T> findEntityByHQL(String hql, Object[] objects) throws DataAccessException;
	
	//以分页的方式获得实体
	public EntryPage query(final String hql, int page, final int size) throws DataAccessException;

	//统计一个HQL语句执行结果的总记录数
	public int count(String hql)throws DataAccessException;

	public int count(String hql,Object ...objects)throws DataAccessException;
}

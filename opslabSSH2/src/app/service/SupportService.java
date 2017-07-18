package app.service;

import app.annotation.ServiceMethod;
import app.annotation.ServiceType;
import app.entries.EntryPage;
import app.exception.ServicesException;

import java.util.List;

/**
 * 
 * @Summary:
 * 		实体的业务层对应的操作方法
 * 	注意：
 * 		此处使用非表明该操作属于业务层
 * 
 *
 */
public interface SupportService<T> {
	
	@ServiceMethod(type=ServiceType.BUSINESS,name="保存实体方法")
	public void save(T t) throws ServicesException;
	
	@ServiceMethod(type=ServiceType.BUSINESS,name="更新实体方法")
	public void update(T t)throws ServicesException;
	
	@ServiceMethod(type=ServiceType.BUSINESS,name="更新活保存实体方法")
	public void saveOrUpdate(T t)throws ServicesException;
	
	@ServiceMethod(type=ServiceType.SYSTEM,name="批量执行HQL")
	public int batchByHQL(String hql,Object ...objects)throws ServicesException;
	
	@ServiceMethod(type=ServiceType.BUSINESS,name="删除实体方法")
	public void delete(T t)throws ServicesException;
	
	@ServiceMethod(type=ServiceType.BUSINESS,name="加载实体方法")
	public T load(Integer id)throws ServicesException;

	@ServiceMethod(type=ServiceType.BUSINESS,name="加载实体方法")
	public T load(String id)throws ServicesException;

	@ServiceMethod(type=ServiceType.BUSINESS,name="加载实体方法")
	public T get(Integer id)throws ServicesException;

	@ServiceMethod(type=ServiceType.BUSINESS,name="加载实体方法")
	public T get(String id)throws ServicesException;
	
	@ServiceMethod(type=ServiceType.BUSINESS,name="加载实体集合方法HQL")
	public List<T> getListByHQL(String hql,Object ...objects)throws ServicesException;
	
	@ServiceMethod(type=ServiceType.BUSINESS,name="加载实体集合方法SQL")
	public List<T> getListBySQL(String sql,Object ...objects)throws ServicesException;
	
	@ServiceMethod(type=ServiceType.BUSINESS,name="加载实体集合方法HQL")
	public List<T> findByHQL(String hql, Object... objects)throws ServicesException;
	
	@ServiceMethod(type=ServiceType.BUSINESS,name="加载实体分页集合方法")
	public EntryPage query(final String hql, int page, final int size)throws ServicesException;

	@ServiceMethod(type=ServiceType.SYSTEM,name="分页获取实体记录")
	public EntryPage getPage(int page, int size)throws ServicesException;

}

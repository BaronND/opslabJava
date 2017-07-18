package com.opslab.workflow.framework.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.opslab.workflow.framework.annotation.ServiceMethod;
import com.opslab.workflow.framework.entity.Page;
import com.opslab.workflow.framework.exception.DataAccessException;
import com.opslab.workflow.framework.exception.ServicesException;
import com.opslab.workflow.framework.service.SupportService;

/**
 * @author 0opslab
 *         通用的业务层方法实现
 */
@SuppressWarnings({"unchecked","rawtypes"})
public abstract class SupportServiceImpl<T, ID extends Serializable> implements SupportService<T, ID> {

    
	@Override
    @ServiceMethod("保存实体方法")
    public void save(T t) throws ServicesException {
        getdb().save(t);
    }

    @Override
    @ServiceMethod("更新实体方法")
    public void update(T t) throws ServicesException {
        getdb().update(t);
    }

    @Override
    @ServiceMethod("更新活保存实体方法")
    public void saveOrUpdate(T t) throws ServicesException {
        getdb().saveOrUpdate(t);
    }

    @Override
    @ServiceMethod("删除实体方法")
    public void delete(T t) throws ServicesException {
        getdb().delete(t);
    }

    @Override
    @ServiceMethod("删除实体方法")
    public void deleteById(ID id) throws ServicesException {
        getdb().deleteById(id);
    }

	@Override
    @ServiceMethod("删除一组实体")
    public void deleteAll(Collection cons) throws ServicesException {
        getdb().deleteAll(cons);
    }

    @Override
    @ServiceMethod("加载实体方法")
    public T load(ID id) throws ServicesException {
        return (T) getdb().load(id);
    }

    @Override
    @ServiceMethod("加载实体方法")
    public T get(ID id) throws ServicesException {
        return (T) getdb().get(id);
    }

    @Override
    @ServiceMethod("执行统计")
    public int count(String hql, Object... params) throws ServicesException {
        return getdb().count(hql, params);
    }

    @Override
    @ServiceMethod("获取一个普通查询HQL的执行记录记录数")
    public int countCommon(String hql, Object... params) throws ServicesException {
        return getdb().countCommon(hql, params);
    }

    @Override
    @ServiceMethod("查询一组对象")
    public List<T> query(String hql, Object... params) throws ServicesException {
        return getdb().query(hql, params);
    }

    @Override
    @ServiceMethod("通过HQL查询第一个实体")
    public T queryFirst(String hql, Object... params) throws ServicesException {
        return (T) getdb().queryFirst(hql, params);
    }

    @Override
    @ServiceMethod("通过HQL查询最后实体")
    public T queryLast(String hql, Object... params) throws DataAccessException {
        return (T) getdb().queryLast(hql, params);
    }

    @Override
    @ServiceMethod("加载实体分页集合方法")
    public Page page(String hql, int page, int size, Object... params) throws ServicesException {
        return getdb().page(hql, page, size, params);
    }
}

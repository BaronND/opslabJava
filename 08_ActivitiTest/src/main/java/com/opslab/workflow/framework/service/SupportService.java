package com.opslab.workflow.framework.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.opslab.workflow.framework.dao.SupportDao;
import com.opslab.workflow.framework.entity.Page;
import com.opslab.workflow.framework.exception.DataAccessException;
import com.opslab.workflow.framework.exception.ServicesException;

/**
 * 实体的业务层对应的操作方法
 * 注意：
 * 此处使用非表明该操作属于业务层
 */
@SuppressWarnings("rawtypes")
public interface SupportService<T, ID extends Serializable> {

	public SupportDao getdb();

    public void save(T t) throws ServicesException;


    public void update(T t) throws ServicesException;


    public void saveOrUpdate(T t) throws ServicesException;


    public void delete(T t) throws ServicesException;


    public void deleteById(ID id) throws ServicesException;


    public void deleteAll(Collection cons) throws ServicesException;


    public T load(ID id) throws ServicesException;


    public T get(ID id) throws ServicesException;


    public int count(String hql, Object... params) throws ServicesException;


    public int countCommon(String hql, Object... params) throws ServicesException;


    public List<T> query(String hql, Object... params) throws ServicesException;


    public T queryFirst(String hql, Object... params) throws ServicesException;


    public T queryLast(String hql, Object... params) throws DataAccessException;


    public Page page(String hql, int page, int size, Object... params) throws ServicesException;



}

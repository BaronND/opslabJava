package com.opslab.workflow.framework.dao.impl;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opslab.workflow.framework.dao.SupportDao;
import com.opslab.workflow.framework.dao.util.HibernateUtil;
import com.opslab.workflow.framework.entity.Page;
import com.opslab.workflow.framework.exception.DataAccessException;

/**
 * ***************************************************************
 *
 * @summary: 用于完成DAO操作的抽象基类，主要用于继承
 * ****************************************************************
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public  class SupportDaoImpl<T,ID extends Serializable> implements SupportDao<T,ID> {


    @Resource(name = "sessionFactory")
    
    private SessionFactory sessionFactory;

    
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	private Session session() {
        return sessionFactory.getCurrentSession();
    }



    // 构造时初始（获取泛型）
    private Class<T> clazz;

    public SupportDaoImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
    }


    /**
     * 返回一个count语句的查询结果
     * @param hql
     * @param params
     * @throws DataAccessException
     */
    @Override
    public int count(String hql,Object... params) throws DataAccessException{
        Query query = session().createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return Integer.parseInt(query.list().get(0).toString());
    }

    /**
     * 返回一个非count语句的记录总数
     * @param hql
     * @param params
     * @throws DataAccessException
     */
    @Override
    public int countCommon(String hql,Object... params) throws DataAccessException{

        String countHQL = "SELECT COUNT(*) FROM ("+hql+") t";
        return count(countHQL,params);
    }

    @Override
    public void save(T o) throws DataAccessException {
        session().save(o);
    }

    @Override
    public void update(T o) throws DataAccessException {
        session().update(o);
    }

    @Override
    public void saveOrUpdate(T o) throws DataAccessException {
        session().saveOrUpdate(o);
    }

    @Override
    public void delete(T t) throws DataAccessException {
        session().delete(t);
    }

    @Override
    public void deleteById(ID id) throws DataAccessException {
        T t = (T) session().get(clazz, id);
        if (t != null) {
            session().delete(t);
        }
    }

    @Override
    public void deleteAll(Collection<T> entities) throws DataAccessException {
        if (entities != null) {
            Session session = session();
            for (T t : entities) {
                session.delete(t);
            }
        }
    }

    @Override
    public T load(ID id) throws DataAccessException {
        return (T) session().load(clazz, id);
    }

    @Override
    public T get(ID id) throws DataAccessException {
        return (T) session().get(clazz, id);
    }

    @Override
    public List<T> query(String hql,Object... params) throws DataAccessException{
        Query query = session().createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return query.list();
    }

    @Override
    public T queryFirst(String hql,Object... params) throws DataAccessException {
        List<T> list = query(hql,params);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }



    @Override
    public T queryLast(String hql,Object... params) throws DataAccessException {
        List<T> list = query(hql,params);
        if(list != null && list.size() > 0){
            return list.get(list.size() -1);
        }
        return null;
    }



    @Override
    public Page page(String hql, int page, int size, Object... params) throws DataAccessException {
        Page pageInfo = new Page();
        pageInfo.setPageSize(size);
        pageInfo.setCurrentPage(page);
        pageInfo.init();
        try {
            pageInfo.setAllRow(count(HibernateUtil.toCount(hql),params));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Query query = session().createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        query.setFirstResult(pageInfo.getOffset());
        query.setMaxResults(size);
        List list = query.list();
        pageInfo.setList(list);

        pageInfo.init();
        return pageInfo;
    }


}

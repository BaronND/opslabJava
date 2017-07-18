package com.opslab.framework.base.dao.impl;

import com.opslab.framework.base.dao.SupportDao;
import com.opslab.framework.base.util.SQLUtil;
import com.opslab.framework.base.util.XmlSQLUtil;
import com.opslab.framework.base.util.impl.CommonXmlSQLUtil;
import com.opslab.util.collection.CollectionUtil;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.*;


@SuppressWarnings({"unchecked", "rawtypes"})
public class SupportDaoImpl<T, ID extends Serializable> implements SupportDao<T, ID> {

    private static Logger logger = Logger.getLogger(SuperQueryDaoImpl.class);

    private static XmlSQLUtil xmlSQLUtil = new CommonXmlSQLUtil();

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }


    // 构造时初始（获取泛型）
    private Class<T> clazz;

    public SupportDaoImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
    }


    @Override
    public void save(T o) {
        session().save(o);
    }

    @Override
    public void update(T o) {
        session().update(o);
    }

    @Override
    public void saveOrUpdate(T o) {
        session().saveOrUpdate(o);
    }

    @Override
    public void delete(T t) {
        session().delete(t);
    }

    @Override
    public void deleteById(ID id) {
        T t = (T) session().get(clazz, id);
        if (t != null) {
            session().delete(t);
        }
    }

    @Override
    public void deleteAll(Collection<T> entities) {
        if (entities != null) {
            Session session = session();
            for (T t : entities) {
                session.delete(t);
            }
        }
    }

    @Override
    public T load(ID id) {
        return (T) session().load(clazz, id);
    }

    @Override
    public T get(ID id) {
        return (T) session().get(clazz, id);
    }

    @Override
    public int execute(String hql, Object... params) {
        Query query = session().createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return query.executeUpdate();
    }

    @Override
    public int executeXml(String queryName, Object... params) {
        String sql = xmlSQLUtil.queryName(queryName);
        return execute(sql, params);
    }


    /**
     * 根据params列表查询条件生成想要的查询条件
     *
     * @param whereExpression
     * @param params
     * @return
     */
    public Query createQuery(String sql, Map<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        StringBuffer sbuf = new StringBuffer(sql);
        Map<String, String> intersection = new HashMap<>();
        Map<String, String> paramTemp = SQLUtil.paramsConvert(params);
        if (whereExpression != null && whereExpression.size() > 0 && params != null && params.size() > 0) {
            intersection = CollectionUtil.intersection(whereExpression, paramTemp);
            if (intersection != null && intersection.size() > 0) {
                String where = com.opslab.util.CollectionUtil.valueJoin(intersection, " and ");
                sbuf.append(" where " + where);
            }
        }
        if (orderBy != null && orderBy.size() > 0) {
            sbuf.append(" order By ");
            sbuf.append(com.opslab.util.CollectionUtil.join(orderBy, " , "));
        }

        String temp = sbuf.toString();
        logger.debug("whereExpression:" + temp);
        Query query = session().createQuery(temp);
        if (intersection != null && intersection.size() > 0) {
            for (Map.Entry<String, String> entry : intersection.entrySet()) {
                String key = entry.getKey();
                query.setParameter(entry.getKey(), params.get(key));
            }
        }
        return query;
    }


    @Override
    public Long count(String hql, Object... params) {
        Query query = session().createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return Long.parseLong(query.list().get(0).toString());
    }

    @Override
    public Long countXml(String queryName, Object... params) {
        String sql = xmlSQLUtil.queryName(queryName);
        return count(sql, params);
    }

    @Override
    public Long countNameParameter(String hql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params) {
        Query query = createQuery(hql, whereExpression, params, null);
        return Long.parseLong(query.uniqueResult().toString());
    }

    @Override
    public Long countNameParameterXml(String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params) {
        String sql = xmlSQLUtil.queryName(queryName);
        return countNameParameter(sql, whereExpression, params);
    }


    @Override
    public List query(String hql, Object... params) {
        Query query = session().createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return query.list();
    }

    @Override
    public List queryXml(String queryName, Object... params) {
        String sql = xmlSQLUtil.queryName(queryName);
        return query(sql, params);
    }

    @Override
    public T queryFirst(String hql, Object... params) {
        List<T> list = queryPage(hql, 1, 10, params);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public T queryFirstXml(String queryName, Object... params) {
        String sql = xmlSQLUtil.queryName(queryName);
        return queryFirst(sql, params);
    }

    @Override
    public List queryNameParameter(String hql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        Query query = createQuery(hql, whereExpression, params, orderBy);
        return query.list();
    }

    @Override
    public List queryNameParameterXml(String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        String sql = xmlSQLUtil.queryName(queryName);
        return queryNameParameter(sql, whereExpression, params, orderBy);
    }

    @Override
    public T queryFirstNameParameter(String hql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        List<T> list = queryPageNameParameter(hql, whereExpression, params, orderBy, 1, 10);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public T queryFirstNameParameterXml(String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        String sql = xmlSQLUtil.queryName(queryName);
        return queryFirstNameParameter(sql, whereExpression, params, orderBy);
    }

    @Override
    public List queryPage(String hql, int page, int size, Object... params) {
        Query query = session().createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List queryPageXml(String queryName, int page, int size, Object... params) {
        String sql = xmlSQLUtil.queryName(queryName);
        return queryPage(sql, page, size, params);
    }

    @Override
    public List queryPageNameParameter(String hql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size) {
        Query query = createQuery(hql, whereExpression, params, orderBy);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List queryPageNameParameterXml(String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size) {
        String sql = xmlSQLUtil.queryName(queryName);
        return queryPageNameParameter(sql, whereExpression, params, orderBy, page, size);
    }


}

package com.opslab.framework.base.dao.impl;

import com.opslab.framework.base.dao.SuperQueryDao;
import com.opslab.framework.base.util.SQLUtil;
import com.opslab.util.collection.CollectionUtil;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 定义Hibernate查询相关的接口
 */
@Repository("dbQuery")
public class SuperQueryDaoImpl implements SuperQueryDao {

    private static Logger logger = Logger.getLogger(SuperQueryDaoImpl.class);

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
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

    public SQLQuery createSQLQuery(String sql, Map<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        StringBuffer sbuf = new StringBuffer(sql);
        Map<String, String> paramTemp = SQLUtil.paramsConvert(params);
        Map<String, String> intersection = new HashMap<>();
        if (whereExpression != null && whereExpression.size() > 0 && params != null && params.size() > 0) {
            intersection = CollectionUtil.intersection(whereExpression, paramTemp);
            if (intersection != null && intersection.size() > 0) {
                String where = com.opslab.util.CollectionUtil.valueJoin(intersection, " and ");
                sbuf.append(" where ");
                sbuf.append(where);
            }
        }
        if (orderBy != null && orderBy.size() > 0) {
            sbuf.append(" order By ");
            sbuf.append(com.opslab.util.CollectionUtil.join(orderBy, " , "));
        }

        String temp = sbuf.toString();
        logger.debug("whereExpression:" + temp);
        SQLQuery sqlquery = session().createSQLQuery(temp);
        if (intersection != null && intersection.size() > 0) {
            for (Map.Entry<String, String> entry : intersection.entrySet()) {
                String key = entry.getKey();
                sqlquery.setParameter(entry.getKey(), params.get(key));
            }
        }
        return sqlquery;
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
    public Long countNameParameter(String hql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params) {
        Query query = createQuery(hql, whereExpression, params, null);
        return Long.parseLong(query.uniqueResult().toString());
    }

    @Override
    public Long countSQL(String sql, Object... params) {
        Query query = session().createSQLQuery(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return Long.parseLong(query.uniqueResult().toString());
    }

    @Override
    public Long countSQLNameParameter(String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params) {
        SQLQuery query = createSQLQuery(sql, whereExpression, params, null);
        return ((Integer)query.uniqueResult()).longValue();
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
    public List queryNameParameter(String hql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        Query query = createQuery(hql, whereExpression, params, orderBy);
        return query.list();
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
    public List queryPageNameParameter(String hql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size) {
        Query query = createQuery(hql, whereExpression, params, orderBy);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public List querySQL(Class clazz, String sql, Object... params) {
        SQLQuery sqlQuery = session().createSQLQuery(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                sqlQuery.setParameter(i, params[i]);
            }
        }
        sqlQuery.addEntity(clazz);
        return sqlQuery.list();
    }

    @Override
    public List querySQLNameParameter(Class clazz, String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        SQLQuery sqlQuery = createSQLQuery(sql, whereExpression, params, orderBy);
        sqlQuery.addEntity(clazz);
        return sqlQuery.list();
    }

    @Override
    public List querySQLPage(Class clazz, String sql, int page, int size, Object... params) {
        SQLQuery sqlQuery = session().createSQLQuery(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                sqlQuery.setParameter(i, params[i]);
            }
        }
        sqlQuery.addEntity(clazz);
        sqlQuery.setFirstResult((page - 1) * size);
        sqlQuery.setMaxResults(size);
        return sqlQuery.list();
    }

    @Override
    public List querySQLPageNameParameter(Class clazz, String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size) {
        SQLQuery sqlQuery = createSQLQuery(sql, whereExpression, params, orderBy);
        sqlQuery.addEntity(clazz);
        sqlQuery.setFirstResult((page - 1) * size);
        sqlQuery.setMaxResults(size);
        return sqlQuery.list();
    }

    @Override
    public List<Object[]> queryArray(String sql, Object... params) {
        SQLQuery sqlQuery = session().createSQLQuery(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                sqlQuery.setParameter(i, params[i]);
            }
        }
        return sqlQuery.list();
    }

    @Override
    public List<Object[]> queryArrayPage(String sql, int page, int size, Object... params) {
        SQLQuery sqlQuery = session().createSQLQuery(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                sqlQuery.setParameter(i, params[i]);
            }
        }
        sqlQuery.setFirstResult((page - 1) * size);
        sqlQuery.setMaxResults(size);
        return sqlQuery.list();
    }

    @Override
    public List<Object[]> queryArrayNameParameter(String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        SQLQuery sqlQuery = createSQLQuery(sql, whereExpression, params, orderBy);
        return sqlQuery.list();
    }

    @Override
    public List<Object[]> queryArrayPageNameParameter(String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size) {
        SQLQuery sqlQuery = createSQLQuery(sql, whereExpression, params, orderBy);
        sqlQuery.setFirstResult((page - 1) * size);
        sqlQuery.setMaxResults(size);
        return sqlQuery.list();
    }

    @Override
    public Object queryFirst(String hql, Object... params) {
        List list = queryPage(hql, 1, 10, params);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Object queryFirstNameParameter(String hql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        List list = queryPageNameParameter(hql, whereExpression, params, orderBy, 1, 10);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Object queryFirstSQL(Class clazz, String sql, Object... params) {
        List list = querySQLPage(clazz, sql, 1, 10, params);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Object queryFirstSQLNameParameter(Class clazz, String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        List list = querySQLPageNameParameter(clazz, sql, whereExpression, params, orderBy, 1, 10);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Object[] queryFirstArray(String sql, Object... params) {
        List<Object[]> objects = queryArrayPage(sql, 1, 10, params);
        if (objects != null && objects.size() > 0) {
            return objects.get(0);
        }
        return null;
    }

    @Override
    public Object[] quaryFirstArrayNameParameter(String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        List<Object[]> objects = queryArrayPageNameParameter(sql, whereExpression, params, orderBy, 1, 10);
        if (objects != null && objects.size() > 0) {
            return objects.get(0);
        }
        return null;
    }

}

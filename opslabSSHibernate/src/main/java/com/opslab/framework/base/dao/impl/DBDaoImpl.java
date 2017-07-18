package com.opslab.framework.base.dao.impl;

import com.opslab.framework.base.dao.DBDao;
import com.opslab.framework.base.util.SQLUtil;
import com.opslab.framework.base.util.XmlSQLUtil;
import com.opslab.framework.base.util.impl.CommonXmlSQLUtil;
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
 * 实现原始SQL的操作接口
 * 此处借用hibnerate的sessionFactory获取相应的链接
 */
@Repository("dbSql")
public class DBDaoImpl implements DBDao {
    private static Logger logger = Logger.getLogger(SuperQueryDaoImpl.class);

    private static XmlSQLUtil xmlSQLUtil = new CommonXmlSQLUtil();

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public int execute(String sql, Object... params) {
        Query query = session().createSQLQuery(sql);
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
        return execute(sql,params);
    }

    public SQLQuery createQuery(String sql, Map<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
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
    public Long count(String sql, Object... params) {
        Query query = session().createSQLQuery(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return Long.parseLong(query.uniqueResult().toString());
    }

    @Override
    public Long countXml(String queryName, Object... params) {
        return null;
    }

    @Override
    public Long countNameParameter(String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params) {
        SQLQuery query = createQuery(sql, whereExpression, params, null);
        return ((Integer) query.uniqueResult()).longValue();
    }

    @Override
    public Long countNameParameterXml(String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params) {
        String sql = xmlSQLUtil.queryName(queryName);
        return countNameParameter(sql, whereExpression, params);
    }

    @Override
    public List query(Class clazz, String sql, Object... params) {
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
    public List queryXml(Class clazz, String queryName, Object... params) {
        String sql = xmlSQLUtil.queryName(queryName);
        return query(clazz, queryName, params);
    }

    @Override
    public List queryNameParameter(Class clazz, String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        SQLQuery sqlQuery = createQuery(sql, whereExpression, params, orderBy);
        sqlQuery.addEntity(clazz);
        return sqlQuery.list();
    }

    @Override
    public List queryNameParameterXml(Class clazz, String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        String sql = xmlSQLUtil.queryName(queryName);
        return queryNameParameter(clazz, sql, whereExpression, params, orderBy);
    }


    @Override
    public List queryPage(Class clazz, String sql, int page, int size, Object... params) {
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
    public List queryPageXml(Class clazz, String queryName, int page, int size, Object... params) {
        String sql = xmlSQLUtil.queryName(queryName);
        return queryPage(clazz, sql, page, size, params);
    }

    @Override
    public List queryPageNameParameter(Class clazz, String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size) {
        SQLQuery sqlQuery = createQuery(sql, whereExpression, params, orderBy);
        sqlQuery.addEntity(clazz);
        sqlQuery.setFirstResult((page - 1) * size);
        sqlQuery.setMaxResults(size);
        return sqlQuery.list();
    }

    @Override
    public List queryPageNameParameterXml(Class clazz, String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size) {
        String sql = xmlSQLUtil.queryName(queryName);
        return queryPageNameParameter(clazz, queryName, whereExpression, params, orderBy, page, size);
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
    public List<Object[]> queryArrayXml(String queryName, Object... params) {
        String sql = xmlSQLUtil.queryName(queryName);
        return queryArray(sql, params);
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
    public List<Object[]> queryArrayPageXml(String queryName, int page, int size, Object... params) {
        String sql = xmlSQLUtil.queryName(queryName);
        return queryArrayPage(sql, page, size, params);
    }

    @Override
    public List<Object[]> queryArrayNameParameter(String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        SQLQuery sqlQuery = createQuery(sql, whereExpression, params, orderBy);
        return sqlQuery.list();
    }

    @Override
    public List<Object[]> queryArrayNameParameterXml(String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        String sql = xmlSQLUtil.queryName(queryName);
        return queryArrayNameParameter(sql, whereExpression, params, orderBy);
    }

    @Override
    public List<Object[]> queryArrayPageNameParameter(String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size) {
        SQLQuery sqlQuery = createQuery(sql, whereExpression, params, orderBy);
        sqlQuery.setFirstResult((page - 1) * size);
        sqlQuery.setMaxResults(size);
        return sqlQuery.list();
    }

    @Override
    public List<Object[]> queryArrayPageNameParameterXml(String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size) {
        String sql = xmlSQLUtil.queryName(queryName);
        return queryArrayPageNameParameter(sql, whereExpression, params, orderBy, page, size);
    }


    @Override
    public Object queryFirstSQL(Class clazz, String sql, Object... params) {
        List list = queryPage(clazz, sql, 1, 10, params);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Object queryFirstSQLXml(Class clazz, String queryName, Object... params) {
        String sql = xmlSQLUtil.queryName(queryName);
        return queryFirstSQL(clazz, sql, params);
    }

    @Override
    public Object queryFirstSQLNameParameter(Class clazz, String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        List list = queryPageNameParameter(clazz, sql, whereExpression, params, orderBy, 1, 10);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }


    @Override
    public Object queryFirstSQLNameParameterXml(Class clazz, String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        String sql = xmlSQLUtil.queryName(queryName);
        return queryFirstSQLNameParameter(clazz, sql, whereExpression, params, orderBy);
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
    public Object[] queryFirstArrayXml(String queryName, Object... params) {
        String sql = xmlSQLUtil.queryName(queryName);
        return queryFirstArray(sql, params);
    }

    @Override
    public Object[] queryFirstArrayNameParameter(String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        List<Object[]> objects = queryArrayPageNameParameter(sql, whereExpression, params, orderBy, 1, 10);
        if (objects != null && objects.size() > 0) {
            return objects.get(0);
        }
        return null;
    }

    @Override
    public Object[] queryFirstArrayNameParameterXml(String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy) {
        String sql = xmlSQLUtil.queryName(queryName);
        return queryFirstArrayNameParameter(sql, whereExpression, params, orderBy);
    }
}

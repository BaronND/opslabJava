package com.opslab.framework.base.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 提供原始SQL的操作的接口
 */
public interface DBDao {

    /**
     * 执行sql语句
     */
    int execute(String sql, Object... params);
    int executeXml(String queryName, Object... params);

    /**
     * 使用原生的sql count语句进行统计
     */
    Long count(String sql, Object... params);
    Long countXml(String queryName, Object... params);

    /**
     * 使用原生的sql count语句进行统计
     */
    Long countNameParameter(String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params);
    Long countNameParameterXml(String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params);

    /**
     * 使用SQL查询指定类型的实体列表
     *
     */
    List query(Class clazz, String sql, Object... params);
    List queryXml(Class clazz, String queryName, Object... params);

    /**
     * 使用SQL参数命名查询指定类型的实体列表
     */
    List queryNameParameter(Class clazz, String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);
    List queryNameParameterXml(Class clazz, String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);


    /**
     * 使用SQL查询指定类型的实体列表支持分页
     */
    List queryPage(Class clazz, String sql, int page, int size, Object... params);
    List queryPageXml(Class clazz, String queryName, int page, int size, Object... params);

    /**
     * 使用SQL参数查询指定类型的实体列表支持分页
     */
    List queryPageNameParameter(Class clazz, String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size);
    List queryPageNameParameterXml(Class clazz, String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size);

    /**
     * 使用SQL查询并返回一个Object[]的列表
     *
     * @param sql    查询的sql语句
     * @param params 查询参数
     * @return
     */
    List<Object[]> queryArray(String sql, Object... params);
    List<Object[]> queryArrayXml(String queryName, Object... params);

    /**
     * 使用SQL查询并返回一个Object[]的列表
     */
    List<Object[]> queryArrayPage(String sql, int page, int size, Object... params);
    List<Object[]> queryArrayPageXml(String queryName, int page, int size, Object... params);

    /**
     * 使用SQL查询并返回一个Object[]的列表
     */
    List<Object[]> queryArrayNameParameter(String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);
    List<Object[]> queryArrayNameParameterXml(String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);


    /**
     * 使用SQL命名参数查询并返回一个Object[]的列表支持分页
     *
     * @param sql             查询的sql语句
     * @param whereExpression 组成where查询条件
     * @param params          查询参数
     * @param page            分页
     * @param size            页数
     * @return
     */
    List<Object[]> queryArrayPageNameParameter(String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size);
    List<Object[]> queryArrayPageNameParameterXml(String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size);




    /**
     * 通过SQL查询单个实体
     */
    Object queryFirstSQL(Class clazz, String sql, Object... params);
    Object queryFirstSQLXml(Class clazz, String queryName, Object... params);

    /**
     * 查询单个实体
     */
    Object queryFirstSQLNameParameter(Class clazz, String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);
    Object queryFirstSQLNameParameterXml(Class clazz, String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);

    /**
     * 使用SQL查询并以Object[]的方式返回第一行结果集
     */
    Object[] queryFirstArray(String sql, Object... params);
    Object[] queryFirstArrayXml(String queryName, Object... params);

    /**
     * 使用SQL查询并以Object[]的方式返回第一行结果集
     */
    Object[] queryFirstArrayNameParameter(String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);
    Object[] queryFirstArrayNameParameterXml(String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);

}

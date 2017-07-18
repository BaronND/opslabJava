package com.opslab.framework.base.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 定义Hibernate查询相关的接口
 */
public interface SuperQueryDao {


    /**
     * 返回一个count语句的查询结果
     */
    Long count(String hql, Object... params);

    /**
     * 参数命名话查询
     *
     * @param hql             查询的HQL语句
     * @param whereExpression 组合where条件
     * @param params          命名参数
     * @return
     */
    Long countNameParameter(String hql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params);

    /**
     * 使用原生的sql count语句进行统计
     */
    Long countSQL(String sql, Object... params);

    /**
     * 使用原生的sql count语句进行统计
     *
     * @param sql             sql语句
     * @param whereExpression 组成where条件
     * @param params          查询参数
     * @return
     */
    Long countSQLNameParameter(String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params);

    /**
     * 使用HQL查询获取实体列表
     *
     * @param hql    查询的HQL语句
     * @param params 参数列表
     * @return
     */
    List query(String hql, Object... params);

    /**
     * 使用hql参数命名查询
     *
     * @param hql             hql语句
     * @param whereExpression 组成where查询条件
     * @param params          命名参数列表
     * @return
     */
    List queryNameParameter(String hql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);


    /**
     * 使用HQL获取实体列表支持分页
     *
     * @param hql    查询的HQL语句
     * @param page   分页
     * @param size   页数
     * @param params 参数列表
     * @return
     */
    List queryPage(String hql, int page, int size, Object... params);

    /**
     * 使用HQL的命名参数查询
     *
     * @param hql             查询的HQL语句
     * @param whereExpression 组成where查询条件
     * @param params          命名参数列表
     * @param page            分页
     * @param size            页数
     * @return
     */
    List queryPageNameParameter(String hql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size);


    /**
     * 使用SQL查询指定类型的实体列表
     *
     * @param clazz  查询的实体
     * @param sql    查询的sql语句
     * @param params 查询参数
     * @return
     */
    List querySQL(Class clazz, String sql, Object... params);

    /**
     * 使用SQL参数命名查询指定类型的实体列表
     *
     * @param clazz           查询的实体
     * @param sql             查询的SQL
     * @param whereExpression 组成where查询条件
     * @param params          查询参数
     * @return
     */
    List querySQLNameParameter(Class clazz, String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);


    /**
     * 使用SQL查询指定类型的实体列表支持分页
     *
     * @param clazz  查询的实体
     * @param sql    查询的SQL
     * @param page   分页
     * @param size   页数
     * @param params 查询参数
     * @return
     */
    List querySQLPage(Class clazz, String sql, int page, int size, Object... params);

    /**
     * 使用SQL参数查询指定类型的实体列表支持分页
     *
     * @param clazz           查询的实体
     * @param sql             查询的SQL
     * @param whereExpression 组成where查询条件
     * @param params          查询参数
     * @param page            分页
     * @param size            页数
     * @return
     */
    List querySQLPageNameParameter(Class clazz, String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size);

    /**
     * 使用SQL查询并返回一个Object[]的列表
     *
     * @param sql    查询的sql语句
     * @param params 查询参数
     * @return
     */
    List<Object[]> queryArray(String sql, Object... params);

    /**
     * 使用SQL查询并返回一个Object[]的列表
     *
     * @param sql
     * @param page
     * @param size
     * @param params
     * @return
     */
    List<Object[]> queryArrayPage(String sql, int page, int size, Object... params);

    /**
     * 使用SQL查询并返回一个Object[]的列表
     *
     * @param sql             查询的sql语句
     * @param whereExpression 组成where查询条件
     * @param params          查询参数
     * @return
     */
    List<Object[]> queryArrayNameParameter(String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);


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


    /**
     * 通过HQL查询单个实体
     *
     * @param hql    查询的HQL语句
     * @param params 查询的参数
     * @return
     */
    Object queryFirst(String hql, Object... params);

    /**
     * 通过HQL查询的单个实体
     *
     * @param hql             查询的HQL语句
     * @param whereExpression 组成where查询条件
     * @param params          查询参数
     * @return
     */
    Object queryFirstNameParameter(String hql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);


    /**
     * 通过SQL查询单个实体
     */
    Object queryFirstSQL(Class clazz, String sql, Object... params);

    /**
     * 查询单个实体
     *
     * @param clazz
     * @param sql
     * @param whereExpression
     * @param params
     * @return
     */
    Object queryFirstSQLNameParameter(Class clazz, String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);

    /**
     * 使用SQL查询并以Object[]的方式返回第一行结果集
     */
    Object[] queryFirstArray(String sql, Object... params);

    /**
     * 使用SQL查询并以Object[]的方式返回第一行结果集
     *
     * @param sql
     * @param whereExpression
     * @param params
     * @return
     */
    Object[] quaryFirstArrayNameParameter(String sql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);


}

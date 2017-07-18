package com.opslab.framework.base.service;

import com.opslab.framework.base.dao.SQLType;

import java.util.List;
import java.util.Map;

/**
 * 因为系统的事物是定义在业务层的隐藏讲BDUtils在业务层也进行封装方便测试
 */

public interface DBService {
    /**
     * 执行一个带参数的HQL统计语句并返回结果
     * @param sql
     * @param params
     * @return
     * 
     */
    Long count(String sql, SQLType type, Object... params);

    /**
     * 执行一个更新语句
     * @param update 更新语句
     * @param params 参数
     * @return  受影响的记录总数
     * 
     */
    int update(String update, Object... params);

    /**
     * 批量执行更新
     * @param update
     * @param params
     * @return
     * 
     */
    int[] batchUpdate(String update, Object[][] params);

    /**
     * 执行查询，将每行的结果保存到一个Map对象中，然后将所有Map对象保存到List中
     * @param sql 查询语句
     * @param params 参数
     * @return List<Map>
     * 
     */
    List<Map<String, Object>> find(String sql, Object... params);

    /**
     * 执行一个查询讲第一行包装成Map对象并返回
     * @param sql
     * @param params
     * @return
     * 
     */
    Map<String,Object> findFirstMap(String sql, Object... params) ;

    /**
     * 执行一个查询讲最后一行包装成Map对象并返回
     * @param sql
     * @param params
     * @return
     * 
     */
    Map<String,Object> findLastMap(String sql, Object... params) ;

    /**
     * 执行查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中
     * @param entityClass 类名
     * @param sql sql语句
     * @param params 参数数组
     * @return 查询结果
     */

    <T> List<T> find(Class<T> entityClass, String sql, Object... params);

    /**
     * 执行查询将第一行的结果保存到Bean中
     * @param entityClass bean类型
     * @param sql 查询的SQL
     * @param params 参数
     * @param <T> 泛型
     * @return bean实体
     * 
     */
    <T> T findFirstBean(Class<T> entityClass, String sql, Object... params) ;

    /**
     * 执行查询讲最后一行的结果保存到Bean中并返回
     * @param entityClass bean的class类型
     * @param sql 查询的SQL语句
     * @param params SQL语句的参数
     * @param <T> 泛型
     * @return bean实体
     * 
     */
    <T> T findLastBean(Class<T> entityClass, String sql, Object... params) ;

    /**
     * 将结果集中某一列的数据存放到List中
     * @param sql 查询的SQL语句
     * @param column 需要存储的列
     * @param params SQL的参数
     * @return
     */
    <T>  List<T> findColumn(Class<T> entityClass, String sql, String column, Object... params) ;

    /**
     * 将结果集中第一行中的某一列返回
     * @param entityClass 返回的类型
     * @param sql 查询的SQL
     * @param column 列名
     * @param params 参数
     * @param <T> 泛型
     * @return 指定列的值
     */
    <T> T findFirstColumn(Class<T> entityClass, String sql, String column, Object... params);

    /**
     * 将结果集中最后一行中的某一列返回
     * @param entityClass 返回的类型
     * @param sql 查询的SQL
     * @param column 列名
     * @param params 参数
     * @param <T> 泛型
     * @return 指定列的值
     * 
     */
    <T> T findLastColumn(Class<T> entityClass, String sql, String column, Object... params) ;

    /**
     * 将查询结果封装成Object[]并存入List中饭
     * @param sql 查询的SQL
     * @param params SQL的参数
     * @return List<Object[]>
     * 
     */
    List<Object[]> findArrayList(String sql, Object... params) ;
    /**
     * 将查询结果的第一个记录封装成Object[]返回
     * @param sql 查询的SQL
     * @param params SQL的参数
     * @return Object[]
     * 
     */
    Object[] findFirstArray(String sql, Object... params) ;

    /**
     * 将查询结果的最后一条记录封装成Object[]返回
     * @param sql 查询的SQL
     * @param params sql的参数
     * @return Object[]
     * 
     */
    Object[] findLastArray(String sql, Object... params) ;

}

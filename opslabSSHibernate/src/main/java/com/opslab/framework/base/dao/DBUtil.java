package com.opslab.framework.base.dao;

import java.util.List;
import java.util.Map;

/**
 * @author 0opslab
 * @email 438558488@qq.com
 * 数据库相关的工具类
 * @explain 按照功能应该定义为DBUtil但是DB开头貌似不怎么好看
 *          经常使用的类名能不好看吗？so！not why
 *
 * @Summar
 *      该接口就是对dbutils结果集处理接口ResultSetHandler的一个二次包装
 *      ArrayHandler：把结果集中的第一行数据转成对象数组。
 *      ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。
 *      BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
 *      BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
 *      ColumnListHandler：将结果集中某一列的数据存放到List中。
 *      KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map里，再把这些map再存到一个map里，其key为指定的key。
 *      MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
 *      MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List
 * @See
 *      关于apache-commons-dbutils的具体使用可以插进一下链接
 *          https://github.com/evil0ps/JTest
 */
public interface DBUtil {

    /**
     * 执行一个带参数的SQL统计语句并返回结果
     * @param select 一定是类似select count(*) from dual的hql语句
     * @param params hql语句的参数
     * @return 记录总数
     */
    Long count(String select, Object... params) ;

    Long countXml(String queryName,Object... params);

    Long countRecord(String select,  Object... params);

    Long countRecordXml(String queryName,  Object... params);

    /**
     * 执行一个更新语句
     * @param update 更新语句
     * @param params 参数
     * @return  受影响的记录总数
     * @
     */
    int update(String update, Object... params) ;

    /**
     * 批量执行更新
     * @param update
     * @param params
     * @return
     * @
     */
    int[] batchUpdate(String update, Object[][] params) ;

    /**
     * 执行查询，将每行的结果保存到一个Map对象中，然后将所有Map对象保存到List中
     * 因为该方法很常用所以命名很简单无形中有助于开发
     * @param sql 查询语句
     * @param params 参数
     * @return List<Map>
     * @
     */
    List<Map<String, Object>> find(String sql, Object... params) ;

    /**
     * 执行一个查询讲第一行包装成Map对象并返回
     * @param sql
     * @param params
     * @return
     * @
     */
    Map<String,Object> findFirstMap(String sql, Object... params) ;

    /**
     * 执行一个查询讲最后一行包装成Map对象并返回
     * @param sql
     * @param params
     * @return
     * @
     */
    Map<String,Object> findLastMap(String sql, Object... params) ;

    /**
     * 执行查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中
     * 因为该方法很常用所以命名很简单无形中有助于开发
     * @param entityClass 类名
     * @param sql sql语句
     * @param params 参数数组
     * @return 查询结果
     */

    <T> List<T> find(Class<T> entityClass, String sql, Object... params) ;

    /**
     * 执行查询将第一行的结果保存到Bean中
     * @param entityClass bean类型
     * @param sql 查询的SQL
     * @param params 参数
     * @param <T> 泛型
     * @return bean实体
     * @
     */
    <T> T findFirstBean(Class<T> entityClass, String sql, Object... params) ;

    /**
     * 执行查询讲最后一行的结果保存到Bean中并返回
     * @param entityClass bean的class类型
     * @param sql 查询的SQL语句
     * @param params SQL语句的参数
     * @param <T> 泛型
     * @return bean实体
     * @
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
     * @
     */
     <T> T findLastColumn(Class<T> entityClass, String sql, String column, Object... params) ;

    /**
     * 将查询结果封装成Object[]并存入List中饭
     * @param sql 查询的SQL
     * @param params SQL的参数
     * @return List<Object[]>
     * @
     */
    List<Object[]> findArrayList(String sql, Object... params) ;

    /**
     * 将查询结果的第一个记录封装成Object[]返回
     * @param sql 查询的SQL
     * @param params SQL的参数
     * @return Object[]
     * @
     */
    Object[] findFirstArray(String sql, Object... params) ;

    /**
     * 将查询结果的最后一条记录封装成Object[]返回
     * @param sql 查询的SQL
     * @param params sql的参数
     * @return Object[]
     * @
     */
    Object[] findLastArray(String sql, Object... params) ;

}

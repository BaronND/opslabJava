package com.opslab.framework.base.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opslab.framework.base.dao.DBUtil;
import org.springframework.stereotype.Service;

import com.opslab.framework.base.dao.SQLType;
import com.opslab.framework.base.service.DBService;

/**
 * @author 0opslab
 */
@Service("dbService")
public class DBServiceImpl implements DBService{
    @Resource(name="dbUtils")
    
    private DBUtil db;

    public DBUtil getDb() {
		return db;
	}

	public void setDb(DBUtil db) {
		this.db = db;
	}

	/**
     * 执行一个带参数的HQL统计语句并返回结果
     * @param sql
     * @param params
     * @return
     */
    public Long count( String sql, SQLType type, Object...params){
        return db.count(sql,type,params);
    }

    /**
     * 执行一个更新语句
     * @param update 更新语句
     * @param params 参数
     * @return  受影响的记录总数
     * @
     */
    public int update(String update,Object... params){
        return db.update(update,params);
    }

    /**
     * 批量执行更新
     * @param update
     * @param params
     * @return
     * @
     */
    public int[] batchUpdate(String update,Object[][] params){
        return db.batchUpdate(update,params);
    }

    /**
     * 执行查询，将每行的结果保存到一个Map对象中，然后将所有Map对象保存到List中
     * @param sql 查询语句
     * @param params 参数
     * @return List<Map>
     * @
     */
    public List<Map<String, Object>> find( String sql, Object... params){
        return db.find(sql,params);
    }

    /**
     * 执行一个查询讲第一行包装成Map对象并返回
     * @param sql
     * @param params
     * @return
     * @
     */
    public Map<String,Object> findFirstMap(String sql,Object... params) {
        return db.findFirstMap(sql,params);
    }

    /**
     * 执行一个查询讲最后一行包装成Map对象并返回
     * @param sql
     * @param params
     * @return
     * @
     */
    public Map<String,Object> findLastMap(String sql,Object... params) {
        return db.findLastMap(sql,params);
    }

    /**
     * 执行查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中
     * @param entityClass 类名
     * @param sql sql语句
     * @param params 参数数组
     * @return 查询结果
     */

    public <T> List<T> find( Class<T> entityClass, String sql, Object... params){
        return db.find(entityClass,sql,params);
    }

    /**
     * 执行查询将第一行的结果保存到Bean中
     * @param entityClass bean类型
     * @param sql 查询的SQL
     * @param params 参数
     * @param <T> 泛型
     * @return bean实体
     * @
     */
    public <T> T findFirstBean(Class<T> entityClass,String sql,Object... params) {
        return db.findFirstBean(entityClass,sql,params);
    }

    /**
     * 执行查询讲最后一行的结果保存到Bean中并返回
     * @param entityClass bean的class类型
     * @param sql 查询的SQL语句
     * @param params SQL语句的参数
     * @param <T> 泛型
     * @return bean实体
     * @
     */
    public <T> T findLastBean(Class<T> entityClass,String sql,Object... params) {
        return db.findLastBean(entityClass,sql,params);
    }

    /**
     * 将结果集中某一列的数据存放到List中
     * @param sql 查询的SQL语句
     * @param column 需要存储的列
     * @param params SQL的参数
     * @return
     */
    public <T>  List<T> findColumn(Class<T> entityClass,String sql,String column,Object... params) {
        return db.findColumn(entityClass,sql,column);
    }

    /**
     * 将结果集中第一行中的某一列返回
     * @param entityClass 返回的类型
     * @param sql 查询的SQL
     * @param column 列名
     * @param params 参数
     * @param <T> 泛型
     * @return 指定列的值
     */
    public <T> T findFirstColumn(Class<T> entityClass,String sql,String column,Object... params){
        return db.findFirstColumn(entityClass,sql,column,params);
    }

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
    public <T> T findLastColumn(Class<T> entityClass,String sql,String column,Object... params) {
        return db.findLastColumn(entityClass,sql,column,params);
    }

    /**
     * 将查询结果封装成Object[]并存入List中饭
     * @param sql 查询的SQL
     * @param params SQL的参数
     * @return List<Object[]>
     * @
     */
    public List<Object[]> findArrayList(String sql,Object... params) {
        return db.findArrayList(sql,params);
    }

    /**
     * 将查询结果的第一个记录封装成Object[]返回
     * @param sql 查询的SQL
     * @param params SQL的参数
     * @return Object[]
     * @
     */
    public Object[] findFirstArray(String sql,Object... params) {
        return db.findFirstArray(sql,params);
    }

    /**
     * 将查询结果的最后一条记录封装成Object[]返回
     * @param sql 查询的SQL
     * @param params sql的参数
     * @return Object[]
     * @
     */
    public Object[] findLastArray(String sql,Object... params) {
        return db.findLastArray(sql,params);
    }
}

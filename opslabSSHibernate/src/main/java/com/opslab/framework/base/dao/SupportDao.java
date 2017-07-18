package com.opslab.framework.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 业务实例的DAO层的操作API定义接口
 * 注意此处的方法都通过entry标识也操作属于DAO层
 * 泛型说明
 * T	业务实体类型
 * ID	业务实体主键类型
 * 凡是以XML结尾的方法都是从XML配置文件中获取SQL语句并执行
 */
public interface SupportDao<T, ID extends Serializable> {

    /**
     * 保存实体
     */
    void save(T t);

    /**
     * 更新实体
     */
    void update(T t);

    /**
     * 保存或更新
     */
    void saveOrUpdate(T t);

    /**
     * 删除实体
     */
    void delete(T t);

    /**
     * 删除实体
     */
    void deleteById(ID id);

    /**
     * 删除实体
     */
    void deleteAll(Collection<T> entities);

    /**
     * 加载实体
     */
    T load(ID id);


    /**
     * 加载实体
     */
    T get(ID id);

    /**
     * 执行hql语句
     */
    int execute(String hql, Object... params);

    int executeXml(String queryName, Object... params);

    /**
     * 返回一个count语句的查询结果
     */
    Long count(String hql, Object... params);

    Long countXml(String queryName, Object... params);

    /**
     * 参数命名话查询
     *
     * @param hql             查询的HQL语句
     * @param whereExpression 组合where条件
     * @param params          命名参数
     */
    Long countNameParameter(String hql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params);

    Long countNameParameterXml(String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params);


    /**
     * 使用HQL查询获取实体列表
     */
    List query(String hql, Object... params);

    List queryXml(String queryName, Object... params);

    /**
     * 通过HQL查询单个实体
     */
    T queryFirst(String hql, Object... params);

    T queryFirstXml(String queryName, Object... params);

    /**
     * 使用HQL获取实体列表支持分页
     */
    List queryPage(String hql, int page, int size, Object... params);

    List queryPageXml(String queryName, int page, int size, Object... params);

    /**
     * 使用hql参数命名查询
     */
    List queryNameParameter(String hql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);

    List queryNameParameterXml(String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);

    /**
     * 通过HQL查询单个实体
     */
    T queryFirstNameParameter(String hql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);

    T queryFirstNameParameterXml(String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy);

    /**
     * 使用HQL的命名参数查询
     */
    List queryPageNameParameter(String hql, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size);

    List queryPageNameParameterXml(String queryName, LinkedHashMap<String, String> whereExpression, Map<String, Object> params, List<String> orderBy, int page, int size);


}

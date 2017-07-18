package com.opslab.framework.base.dao.impl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.opslab.framework.base.dao.DBUtil;
import com.opslab.framework.base.dao.SQLType;
import com.opslab.framework.base.util.XmlSQLUtil;
import com.opslab.framework.base.util.impl.CommonXmlSQLUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


/**
 * 数据库相关的工具分装
 */
@Repository("dbUtils")
public class DBUtilsImpl implements DBUtil {

    private static final Logger logger = Logger.getLogger(DBUtilsImpl.class);

    private static XmlSQLUtil xmlSQLUtil = new CommonXmlSQLUtil();

    @Resource(name = "dataSource")
    private DataSource dataSource;


    private QueryRunner queryRunner;



    @Override
    public int update(String update, Object... params) {
        logger.debug(update + "[parameter]:" + Arrays.toString(params));
        queryRunner = new QueryRunner(dataSource, true);
        try {
            return queryRunner.update(update, params);
        } catch (SQLException e) {
            logger.debug(update + "[parameter]:" + Arrays.toString(params) + "[Exception]:" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public int[] batchUpdate(String update, Object[][] params) {
        logger.debug(update + "[parameter]:" + Arrays.toString(params));
        queryRunner = new QueryRunner(dataSource, true);
        try {
            return queryRunner.batch(update, params);
        } catch (SQLException e) {
            logger.debug(update + "[parameter]:" + Arrays.toString(params) + "[Exception]:" + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    // map相关的操作
    @Override
    public List<Map<String, Object>> find(String sql, Object... params) {
        logger.debug(sql + "[parameter]:" + Arrays.toString(params));
        queryRunner = new QueryRunner(dataSource, true);
        try {
            return queryRunner.query(sql, new MapListHandler());
        } catch (SQLException e) {
            logger.debug(sql + "[parameter]:" + Arrays.toString(params) + "[Exception]:" + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @Override
    public Map<String, Object> findFirstMap(String sql, Object... params) {
        logger.debug(sql + "[parameter]:" + Arrays.toString(params));
        List<Map<String, Object>> maps = find(sql, params);
        if (maps != null && maps.size() > 0) {
            return maps.get(0);
        }
        return null;
    }

    @Override
    public Map<String, Object> findLastMap(String sql, Object... params) {
        logger.debug(sql + "[parameter]:" + Arrays.toString(params));
        List<Map<String, Object>> maps = find(sql, params);
        if (maps != null && maps.size() > 0) {
            return maps.get(maps.size() - 1);
        }
        return null;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    // bean相关的操作
    @Override
    public <T> List<T> find(Class<T> entityClass, String sql, Object... params) {
        logger.debug(sql + "[parameter]:" + Arrays.toString(params));
        queryRunner = new QueryRunner(dataSource, true);
        try {
            return queryRunner.query(sql, new BeanListHandler<T>(entityClass),
                    params);
        } catch (SQLException e) {
            logger.debug(sql + "[parameter]:" + Arrays.toString(params) + "[Exception]:" + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @Override
    public <T> T findFirstBean(Class<T> entityClass, String sql,
                               Object... params) {
        logger.debug(sql + "[parameter]:" + Arrays.toString(params));
        List<T> list = find(entityClass, sql, params);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public <T> T findLastBean(Class<T> entityClass, String sql,
                              Object... params) {
        logger.debug(sql + "[parameter]:" + Arrays.toString(params));
        List<T> list = find(entityClass, sql, params);
        if (list != null && list.size() > 0) {
            return list.get(list.size() - 1);
        }
        return null;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    // 单列相关的查询
    @Override
    public <T> List<T> findColumn(Class<T> entityClass, String sql,
                                  String column, Object... params) {
        logger.debug(sql + "[parameter]:" + Arrays.toString(params));
        queryRunner = new QueryRunner(dataSource, true);
        try {
            return queryRunner.query(sql, new ColumnListHandler<T>(), params);
        } catch (SQLException e) {
            logger.debug(sql + "[parameter]:" + Arrays.toString(params) + "[Exception]:" + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @Override
    public <T> T findFirstColumn(Class<T> entityClass, String sql,
                                 String column, Object... params) {
        logger.debug(sql + "[parameter]:" + Arrays.toString(params));
        List<T> list = findColumn(entityClass, sql, column, params);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public <T> T findLastColumn(Class<T> entityClass, String sql, String column,
                                Object... params) {
        logger.debug(sql + "[parameter]:" + Arrays.toString(params));
        List<T> list = findColumn(entityClass, sql, column, params);
        if (list != null && list.size() > 0) {
            return list.get(list.size() - 1);
        }
        return null;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    // 数组相关
    @Override
    public List<Object[]> findArrayList(String sql, Object... params) {
        logger.debug(sql + "[parameter]:" + Arrays.toString(params));
        queryRunner = new QueryRunner(dataSource, true);
        try {
            return queryRunner.query(sql, new ArrayListHandler(), params);
        } catch (SQLException e) {
            logger.debug(sql + "[parameter]:" + Arrays.toString(params) + "[Exception]:" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object[] findFirstArray(String sql, Object... params) {
        logger.debug(sql + "[parameter]:" + Arrays.toString(params));
        List<Object[]> list = findArrayList(sql, new ArrayListHandler(),
                params);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Object[] findLastArray(String sql, Object... params) {
        logger.debug(sql + "[parameter]:" + Arrays.toString(params));
        List<Object[]> list = findArrayList(sql, new ArrayListHandler(),
                params);
        if (list != null && list.size() > 0) {
            return list.get(list.size() - 1);
        }
        return null;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    // count相关的块
    @Override
    public Long countRecord(String select,  Object... params) {
        String count = "select count(*) from (" + select + ") t";
        logger.debug(count + "[parameter]:" + Arrays.toString(params));
        return count(count,params);

    }

    @Override
    public Long countRecordXml(String queryName, Object... params) {
        String sql = xmlSQLUtil.queryName(queryName);
        return countRecord(sql,params);
    }

    /**
     * 执行count类型的hql语句并返回记录总数
     *
     * @param sql    count类型的hql语句
     * @param params hql语句的参数
     * @return 记录总算
     * @
     */
    public Long count(String sql, Object... params) {
        logger.debug(sql + "[parameter]:" + Arrays.toString(params));
        queryRunner = new QueryRunner(dataSource, true);
        try {
            return queryRunner.query(sql, new ScalarHandler<Long>(), params)
                    .longValue();
        } catch (SQLException e) {
            logger.debug(sql + "[parameter]:" + Arrays.toString(params) + "[Exception]:" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long countXml(String queryName, Object... params) {
        String sql = xmlSQLUtil.queryName(queryName);
        return count(sql,params);
    }


}

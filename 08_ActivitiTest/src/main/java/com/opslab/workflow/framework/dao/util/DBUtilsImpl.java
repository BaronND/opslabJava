package com.opslab.workflow.framework.dao.util;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.opslab.workflow.framework.exception.DataAccessException;

/**
 * 数据库相关的工具分装
 */
@Repository("dbUtils")
public class DBUtilsImpl implements db {
	@Resource(name = "dataSource")
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private QueryRunner queryRunner;

	private static final Logger LOG = Logger.getLogger(DBUtilsImpl.class);

	@Override
	public int update(String update, Object... params)
			throws DataAccessException {
		queryRunner = new QueryRunner(dataSource, true);
		try {
			return queryRunner.update(update, params);
		} catch (SQLException e) {
			LOG.error("sql error:" + e.getMessage());
			throw new DataAccessException(e);
		}
	}

	@Override
	public int[] batchUpdate(String update, Object[][] params)
			throws DataAccessException {
		queryRunner = new QueryRunner(dataSource, true);
		try {
			return queryRunner.batch(update, params);
		} catch (SQLException e) {
			LOG.error("sql error:" + e.getMessage());
			throw new DataAccessException(e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////
	// map相关的操作
	@Override
	public List<Map<String, Object>> find(String sql, Object... params)
			throws DataAccessException {
		queryRunner = new QueryRunner(dataSource, true);
		try {
			return queryRunner.query(sql, new MapListHandler());
		} catch (SQLException e) {
			LOG.error("sql error:" + e.getMessage());
			throw new DataAccessException(e);
		}
	}

	@Override
	public Map<String, Object> findFirstMap(String sql, Object... params)
			throws DataAccessException {
		List<Map<String, Object>> maps = find(sql, params);
		if (maps != null && maps.size() > 0) {
			return maps.get(0);
		}
		return null;
	}

	@Override
	public Map<String, Object> findLastMap(String sql, Object... params)
			throws DataAccessException {
		List<Map<String, Object>> maps = find(sql, params);
		if (maps != null && maps.size() > 0) {
			return maps.get(maps.size() - 1);
		}
		return null;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////
	// bean相关的操作
	@Override
	public <T> List<T> find(Class<T> entityClass, String sql, Object... params)
			throws DataAccessException {
		queryRunner = new QueryRunner(dataSource, true);
		try {
			return queryRunner.query(sql, new BeanListHandler<T>(entityClass),
					params);
		} catch (SQLException e) {
			LOG.error("sql error:" + e.getMessage());
			throw new DataAccessException(e);
		}
	}

	@Override
	public <T> T findFirstBean(Class<T> entityClass, String sql,
			Object... params) throws DataAccessException {
		List<T> list = find(entityClass, sql, params);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public <T> T findLastBean(Class<T> entityClass, String sql,
			Object... params) throws DataAccessException {
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
			String column, Object... params) throws DataAccessException {
		queryRunner = new QueryRunner(dataSource, true);
		try {
			return queryRunner.query(sql, new ColumnListHandler<T>(), params);
		} catch (SQLException e) {
			LOG.error("sql error:" + e.getMessage());
			throw new DataAccessException(e);
		}
	}

	@Override
	public <T> T findFirstColumn(Class<T> entityClass, String sql,
			String column, Object... params) throws DataAccessException {
		List<T> list = findColumn(entityClass, sql, column, params);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public <T> T findLastColumn(Class<T> entityClass, String sql, String column,
			Object... params) throws DataAccessException {
		List<T> list = findColumn(entityClass, sql, column, params);
		if (list != null && list.size() > 0) {
			return list.get(list.size() - 1);
		}
		return null;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////
	// 数组相关
	@Override
	public List<Object[]> findArrayList(String sql, Object... params)
			throws DataAccessException {
		queryRunner = new QueryRunner(dataSource, true);
		try {
			return queryRunner.query(sql, new ArrayListHandler(), params);
		} catch (SQLException e) {
			LOG.error("sql error:" + e.getMessage());
			throw new DataAccessException(e);
		}
	}

	@Override
	public Object[] findFirstArray(String sql, Object... params)
			throws DataAccessException {
		List<Object[]> list = findArrayList(sql, new ArrayListHandler(),
				params);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Object[] findLastArray(String sql, Object... params)
			throws DataAccessException {
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
	public int count(String select, SQLType type, Object... params)
			throws DataAccessException {
		switch (type) {
		case SQL:
			return countOrdinarySQL(select, params);
		case COUNT_SQL:
			return countSQL(select, params);
		default:
			return countOrdinarySQL(select, params);
		}
	}

	/**
	 * 执行count类型的hql语句并返回记录总数
	 *
	 * @param sql
	 *            count类型的hql语句
	 * @param params
	 *            hql语句的参数
	 * @return 记录总算
	 * @throws DataAccessException
	 */
	private int countSQL(String sql, Object... params)
			throws DataAccessException {
		int count = 0;
		queryRunner = new QueryRunner(dataSource, true);
		try {
			count = queryRunner.query(sql, new ScalarHandler<Long>(), params)
					.intValue();
		} catch (SQLException e) {
			LOG.error("SQL-COUNT ERROR:" + e.getMessage());
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 执行count类型的sql语句并返回记录总数
	 * 本打算使用sqlparser将sql解析后优化处理再查询，但是sqlparer的解析有问题故使用下面这种方式 select count(*)
	 * from (sql)
	 *
	 * @param sql
	 *            count类型的hql语句
	 * @param params
	 *            sql语句的参数
	 * @return 记录总算
	 * @throws DataAccessException
	 */
	private int countOrdinarySQL(String sql, Object... params)
			throws DataAccessException {
		String countsql = "select count(*) from (" + sql + ") t";
		return countSQL(countsql, params);
	}
}

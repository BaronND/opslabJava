package com.opslab.workflow.framework.dao.util;

import java.util.Objects;

import com.opslab.workflow.framework.exception.DataAccessException;

/**
 * Hibernate操作相关的工具类
 */
@SuppressWarnings("unused")
public class HDBUtil {

    /**
     * 执行count类型的hql语句并返回记录总数
     * @param hql count类型的hql语句
     * @param params hql语句的参数
     * @return 记录总算
     * @throws DataAccessException
     */
	private int countHQL(String hql, Objects... params) throws DataAccessException {
        return 0;
    }

    /**
     * 执行普通select类型的hql语句并返回其记录总数
     * @param hql 普通的hql语句
     * @param params 普通的hql语句
     * @return 记录总数
     * @throws DataAccessException
     */
    private int countOrdinaryHQL(String hql,Objects... params) throws DataAccessException {
        return 0;
    }


}

package com.opslab.workflow.framework.dao.util;

/**
 * SQL语句类型
 */
public enum SQLType {
    SQL,//正常的SQL语句
    HQL,//政策的HQL语句
    COUNT_SQL,//统计的SQL语句
    COUNT_HQL,//统计的HQL语句
}

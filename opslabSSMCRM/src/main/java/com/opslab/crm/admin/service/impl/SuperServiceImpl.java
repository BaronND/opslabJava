package com.opslab.crm.admin.service.impl;

import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;

/**
 * Created by neptune
 */
public abstract class SuperServiceImpl {
    @Resource(name = "sqlSession")
    protected SqlSession session;
}

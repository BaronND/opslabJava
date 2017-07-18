package com.opslab.core.service.impl;

import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;

/**
 * 通用的业务层service
 */
public class SuperService {
    @Resource(name="sqlSession")
    protected SqlSession session;
}

package com.opslab.blog.admin.service.impl;

import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;

/**
 * Created by neptune on 2017/4/2 0002.
 */
public abstract class SuperServiceImpl {
    @Resource(name = "sqlSession")
    protected SqlSession session;
}


package com.opslab.business.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.opslab.business.service.TestService;

@Service("testService")
public class TestServiceImpl  implements TestService {

    private static Logger logger = Logger.getLogger(TestServiceImpl.class);

    @Resource(name = "sqlSession")
    private SqlSession session;

    public Object queryUserInfoById(String id){
        return null;
    }
}


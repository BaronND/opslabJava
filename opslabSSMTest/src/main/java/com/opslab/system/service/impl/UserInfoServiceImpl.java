package com.opslab.system.service.impl;

import com.google.common.collect.ImmutableMap;
import com.opslab.system.model.UserInfo;
import com.opslab.system.service.UserInfoService;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户操作
 */
@Service("userInfoService")
public class UserInfoServiceImpl  implements UserInfoService {
    private static Logger logger = Logger.getLogger(UserInfoServiceImpl.class);

    @Resource(name = "sqlSession")
    protected SqlSession session;


    @Override
    public UserInfo queryUserInfoById(String id) {
        logger.debug("query user:" + id);
        Map<Object, Object> params =
                ImmutableMap.builder()
                        .put("userid", id)
                        .build();
        return session.selectOne("com.opslab.system.model.UserInfo.queryUser", params);
    }


    @Override
    public List<UserInfo> queryUserByDeptId(String deptId) {
        Map<Object, Object> params =
                ImmutableMap.builder()
                        .put("deptId", deptId)
                        .build();
        return session.selectList("com.opslab.system.model.UserInfo.queryUser", params);
    }

    @Override
    public List<UserInfo> selectList(String deptId, RowBounds rows) {
        Map<Object, Object> params =
                ImmutableMap.builder()
                        .put("deptId", deptId)
                        .build();
        return session.selectList("com.opslab.system.model.UserInfo.queryUser", params, rows);
    }
}

package com.opslab.core.service.impl;

import com.google.common.collect.ImmutableMap;
import com.opslab.core.model.UserInfo;
import com.opslab.core.service.UserInfoService;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户操作
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends SuperService implements UserInfoService {
    private static Logger logger = Logger.getLogger(UserInfoServiceImpl.class);
    @Override
    public UserInfo queryUserInfoById(String id) {
        logger.debug("query user:"+id);
        Map<Object,Object> params=
                ImmutableMap.builder()
                .put("userid",id)
                .build();
        return session.selectOne("com.opslab.core.model.UserInfo.queryUser",params);
    }


    @Override
    public List<UserInfo> queryUserByDeptId(String deptId) {
        Map<Object,Object> params=
                ImmutableMap.builder()
                        .put("deptId",deptId)
                        .build();
        return session.selectList("com.opslab.core.model.UserInfo.queryUser",params);
    }

    @Override
    public List<UserInfo> selectList(String deptId, RowBounds rows) {
        Map<Object,Object> params=
                ImmutableMap.builder()
                        .put("deptId",deptId)
                        .build();
        return session.selectList("com.opslab.core.model.UserInfo.queryUser",params,rows);
    }
}

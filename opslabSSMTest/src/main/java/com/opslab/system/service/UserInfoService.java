package com.opslab.system.service;

import com.opslab.system.annotion.ServiceMethod;
import com.opslab.system.model.UserInfo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 用户操作
 */
public interface UserInfoService {

    @ServiceMethod(type = "USERINO", value = "根据userid查询用户")
    UserInfo queryUserInfoById(String id);

    @ServiceMethod(type = "USERINO", value = "根据deptid查询用户")
    List<UserInfo> queryUserByDeptId(String deptId);

    @ServiceMethod(type = "USERINO", value = "根据deptid查询用户分页")
    List<UserInfo> selectList(String deptId, RowBounds rows);
}

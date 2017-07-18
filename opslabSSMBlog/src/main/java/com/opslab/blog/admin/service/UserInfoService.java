package com.opslab.blog.admin.service;

import com.opslab.blog.admin.annotation.ServiceMethod;
import com.opslab.blog.admin.domain.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @author 0opslab
 * @descript 用户操作接口
 */
public interface UserInfoService {
    @ServiceMethod("获取全部的用户数量")
    int count();

    @ServiceMethod("获取用户列表")
    List<UserInfo> list(Map<Object,Object> params);

    @ServiceMethod("获取用户数量")
    int count(Map<Object,Object> params);

    @ServiceMethod("获取用户列表")
    List<UserInfo> page(Map<Object,Object> params,int page,int size);

    @ServiceMethod("新增用户")
    int save(UserInfo userInfo);

    @ServiceMethod("更新用户状态")
    int updateStatus(int userId,String status);

    @ServiceMethod("获取用户信息")
    UserInfo userInfo(int userId);

    @ServiceMethod("获取用户信息")
    UserInfo userInfoByUserCode(String userCode);

    @ServiceMethod("获取用户信息")
    UserInfo userInfoByUserName(String name);

    @ServiceMethod("获取用户信息")
    UserInfo userInfoByEmail(String email);
}

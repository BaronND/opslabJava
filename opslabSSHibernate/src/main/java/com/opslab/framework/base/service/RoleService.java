package com.opslab.framework.base.service;

import com.opslab.framework.base.annotation.ServiceMethod;
import com.opslab.framework.base.entity.Role;

import java.util.List;

/**
 * 业务方法接口
 */
public interface RoleService extends SupportService<Role, String> {


    @ServiceMethod("获取角色数量")
    Long count(boolean isAll);


    @ServiceMethod("获取角色列表")
    List<Role> list(boolean isAll);


    @ServiceMethod("统计某个角色下有多少用户")
    Long count(String roleId);


    @ServiceMethod("获取指定角色下的用户列表")
    List<Object> userSet(String roleId, int page, int size);

}


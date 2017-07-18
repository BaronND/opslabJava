package com.opslab.framework.base.service;

import com.opslab.framework.base.annotation.ServiceMethod;
import com.opslab.framework.base.entity.WorkGroup;

import java.util.List;

/**
* 业务方法接口
*/
public interface WorkGroupService extends SupportService<WorkGroup,String> {

    @ServiceMethod("统计用户组")
    Long count(boolean isAll);


    @ServiceMethod("获取用户组列表")
    List<WorkGroup> list(boolean isAll);

    @ServiceMethod("统计工作组内的用户数量")
    Long countUser(String groupId);
}


package com.opslab.workflow.framework.service;

import java.util.List;

import com.opslab.workflow.framework.entity.business.UserInfo;

/**
* 业务方法接口
*/
public interface UserInfoService extends SupportService<UserInfo,String> {
    List<Object> list();

}


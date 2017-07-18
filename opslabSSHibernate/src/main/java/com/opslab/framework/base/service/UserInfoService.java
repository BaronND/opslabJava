package com.opslab.framework.base.service;

import com.opslab.framework.base.annotation.ServiceMethod;
import com.opslab.framework.base.entity.UserInfo;

import java.util.List;
import java.util.Map;


/**
* 业务方法接口
*/
public interface UserInfoService extends SupportService<UserInfo,String> {


    @ServiceMethod("统计用户的数量")
    Long count(Map<String,Object> params);


    @ServiceMethod("查询用户")
    List<UserInfo> list(Map<String,Object> params,int page,int size);

}



package com.opslab.business.service;

import com.opslab.system.annotion.ServiceMethod;


public interface TestService {

    /**
     * 保存业务日志
     *
     * @param id
     */
    @ServiceMethod(type = "USERINFO", value = "根据userid查询用户")
    Object queryUserInfoById(String id);

}

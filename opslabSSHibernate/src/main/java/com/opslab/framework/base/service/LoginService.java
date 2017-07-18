package com.opslab.framework.base.service;

import com.opslab.framework.base.annotation.ServiceMethod;

/**
 * 用户登陆
 */
public interface LoginService {
    /**
     * 用户登陆
     * @param userId
     * @param password
     * @return
     */
    @ServiceMethod("用户登陆")
    boolean login(String userId,String password);
}

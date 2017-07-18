package com.opslab.framework.base.service.impl;

import com.opslab.framework.base.annotation.ActionMethod;
import com.opslab.framework.base.entity.UserInfo;
import com.opslab.framework.base.dao.DBUtil;
import com.opslab.framework.base.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户登陆
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Resource(name="dbUtils")
    private DBUtil db;

    @Override

    public boolean login(String userId, String password) {
        String sql = "select * from ops_re_userinfo t where t.userCode=? and t.password=?";
        UserInfo userInfo =  db.findFirstBean(UserInfo.class,sql,new Object[]{userId,password});
        if(userInfo != null){
            return true;
        }
        return false;
    }
}

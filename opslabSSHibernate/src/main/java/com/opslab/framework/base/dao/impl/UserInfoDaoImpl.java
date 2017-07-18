package com.opslab.framework.base.dao.impl;

import org.springframework.stereotype.Repository;

import com.opslab.framework.base.dao.UserInfoDao;
import com.opslab.framework.base.entity.UserInfo;

/**
* 业务实体DAO
*/
@Repository("userInfoDao")
public class UserInfoDaoImpl extends SupportDaoImpl<UserInfo,String> implements UserInfoDao {
}


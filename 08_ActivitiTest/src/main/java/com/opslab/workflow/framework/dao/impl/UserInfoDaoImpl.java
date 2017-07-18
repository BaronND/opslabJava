package com.opslab.workflow.framework.dao.impl;

import org.springframework.stereotype.Repository;

import com.opslab.workflow.framework.dao.UserInfoDao;
import com.opslab.workflow.framework.entity.business.UserInfo;

/**
* 业务实体DAO
*/
@Repository("userInfoDao")
public class UserInfoDaoImpl extends SupportDaoImpl<UserInfo,String> implements UserInfoDao {
}


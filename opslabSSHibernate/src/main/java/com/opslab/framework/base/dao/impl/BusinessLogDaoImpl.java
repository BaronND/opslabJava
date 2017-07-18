package com.opslab.framework.base.dao.impl;

import org.springframework.stereotype.Repository;

import com.opslab.framework.base.dao.BusinessLogDao;
import com.opslab.framework.base.entity.BusinessLog;

/**
 * @author 0opslab
 */
@Repository("businessLogDao")
public class BusinessLogDaoImpl extends SupportDaoImpl<BusinessLog,String> implements BusinessLogDao{
}

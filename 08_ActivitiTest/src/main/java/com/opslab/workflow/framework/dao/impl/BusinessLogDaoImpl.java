package com.opslab.workflow.framework.dao.impl;

import org.springframework.stereotype.Repository;

import com.opslab.workflow.framework.dao.BusinessLogDao;
import com.opslab.workflow.framework.entity.business.BusinessLog;

/**
 * @author 0opslab
 */
@Repository("businessLogDao")
public class BusinessLogDaoImpl extends SupportDaoImpl<BusinessLog,String> implements BusinessLogDao{
}

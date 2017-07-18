package com.opslab.workflow.framework.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.opslab.workflow.framework.dao.BusinessLogDao;
import com.opslab.workflow.framework.dao.SupportDao;
import com.opslab.workflow.framework.entity.business.BusinessLog;
import com.opslab.workflow.framework.service.BusinessLogService;

/**
 * @author 0opslab
 */
@Service("businessLogService")
@SuppressWarnings("rawtypes")
public class BusinessLogServiceImpl extends SupportServiceImpl<BusinessLog,String> implements BusinessLogService{
    @Resource(name="businessLogDao")
    
    private BusinessLogDao db;

    public BusinessLogDao getDb() {
		return db;
	}

	public void setDb(BusinessLogDao db) {
		this.db = db;
	}

	
	@Override
    public SupportDao getdb() {
        return db;
    }
}

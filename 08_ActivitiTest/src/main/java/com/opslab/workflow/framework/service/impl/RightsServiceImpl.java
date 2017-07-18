package com.opslab.workflow.framework.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.opslab.workflow.framework.dao.RightsDao;
import com.opslab.workflow.framework.dao.SupportDao;
import com.opslab.workflow.framework.entity.business.Rights;
import com.opslab.workflow.framework.service.RightsService;

/**
 * @author 0opslab
 * 权限相关的操作
 */
@Service("rightsService")
@SuppressWarnings("rawtypes")
public class RightsServiceImpl extends SupportServiceImpl<Rights,Integer> implements RightsService{
    @Resource(name = "rightsDao")
    
    private RightsDao db;

    public RightsDao getDb() {
		return db;
	}

	public void setDb(RightsDao db) {
		this.db = db;
	}

	@Override
    public SupportDao getdb() {
        return db;
    }
}

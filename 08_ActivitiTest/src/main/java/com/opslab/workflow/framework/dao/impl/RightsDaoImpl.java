package com.opslab.workflow.framework.dao.impl;

import org.springframework.stereotype.Repository;

import com.opslab.workflow.framework.dao.RightsDao;
import com.opslab.workflow.framework.entity.business.Rights;

@Repository("rightsDao")
public class RightsDaoImpl extends SupportDaoImpl<Rights,Integer> implements RightsDao {

}

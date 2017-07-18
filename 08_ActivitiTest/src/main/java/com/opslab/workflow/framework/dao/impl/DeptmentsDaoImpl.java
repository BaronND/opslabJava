package com.opslab.workflow.framework.dao.impl;

import org.springframework.stereotype.Repository;

import com.opslab.workflow.framework.dao.DeptmentsDao;
import com.opslab.workflow.framework.entity.business.Deptments;

/**
* 业务实体DAO
*/
@Repository("deptmentsDao")
public class DeptmentsDaoImpl extends SupportDaoImpl<Deptments,String> implements DeptmentsDao {
}


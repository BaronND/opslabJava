package com.opslab.framework.base.dao.impl;

import org.springframework.stereotype.Repository;

import com.opslab.framework.base.dao.DeptmentsDao;
import com.opslab.framework.base.entity.Deptments;

/**
* 业务实体DAO
*/
@Repository("deptmentsDao")
public class DeptmentsDaoImpl extends SupportDaoImpl<Deptments,String> implements DeptmentsDao {
}


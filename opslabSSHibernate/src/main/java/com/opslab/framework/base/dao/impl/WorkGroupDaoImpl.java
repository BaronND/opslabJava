package com.opslab.framework.base.dao.impl;

import com.opslab.framework.base.dao.WorkGroupDao;
import com.opslab.framework.base.entity.WorkGroup;
import org.springframework.stereotype.Repository;

/**
* 业务实体DAO
*/
@Repository("workGroupDao")
public class WorkGroupDaoImpl extends SupportDaoImpl<WorkGroup,String> implements WorkGroupDao {
}


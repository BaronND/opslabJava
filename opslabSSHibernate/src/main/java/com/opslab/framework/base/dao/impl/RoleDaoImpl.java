package com.opslab.framework.base.dao.impl;

import com.opslab.framework.base.dao.RoleDao;
import com.opslab.framework.base.entity.Role;
import org.springframework.stereotype.Repository;

/**
* 业务实体DAO
*/
@Repository("roleDao")
public class RoleDaoImpl extends SupportDaoImpl<Role,String> implements RoleDao {
}


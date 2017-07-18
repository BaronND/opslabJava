package com.opslab.framework.base.dao.impl;

import com.opslab.framework.base.dao.MenuDao;
import com.opslab.framework.base.entity.Menu;

import org.springframework.stereotype.Repository;

/**
* 业务实体DAO
*/
@Repository("menuDao")
public class MenuDaoImpl extends SupportDaoImpl<Menu,String> implements MenuDao {
}


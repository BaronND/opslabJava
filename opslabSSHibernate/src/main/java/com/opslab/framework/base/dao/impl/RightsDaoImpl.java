package com.opslab.framework.base.dao.impl;

import org.springframework.stereotype.Repository;

import com.opslab.framework.base.dao.RightsDao;
import com.opslab.framework.base.entity.Rights;

@Repository("rightsDao")
public class RightsDaoImpl extends SupportDaoImpl<Rights,Integer> implements RightsDao {

}

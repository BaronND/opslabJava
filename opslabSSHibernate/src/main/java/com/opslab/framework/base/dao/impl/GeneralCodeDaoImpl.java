package com.opslab.framework.base.dao.impl;

import com.opslab.framework.base.dao.GeneralCodeDao;
import com.opslab.framework.base.entity.GeneralCode;
import org.springframework.stereotype.Repository;

/**
* 业务实体DAO
*/
@Repository("generalCodeDao")
public class GeneralCodeDaoImpl extends SupportDaoImpl<GeneralCode,String> implements GeneralCodeDao {
}


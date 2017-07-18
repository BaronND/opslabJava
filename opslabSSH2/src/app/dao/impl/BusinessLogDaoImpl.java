package app.dao.impl;

import org.springframework.stereotype.Repository;

import app.dao.BusinessLogDao;
import app.entries.BusinessLog;

@Repository("businessLogDao")
public class BusinessLogDaoImpl extends SupportDaoImpl<BusinessLog> implements BusinessLogDao {

}

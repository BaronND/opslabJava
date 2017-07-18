package app.dao.impl;

import org.springframework.stereotype.Repository;

import app.dao.RightsDao;
import app.entries.Rights;

@Repository("rightsDao")
public class RightsDaoImpl extends SupportDaoImpl<Rights> implements RightsDao {

}

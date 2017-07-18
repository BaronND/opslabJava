package app.dao.impl;

import app.dao.GeneralCodeDao;
import app.entries.GeneralCode;
import org.springframework.stereotype.Repository;

/**
 * <h6>Description:<h6>
 * <p>时限类</p>
 *
 * @date 2015-06-15.
 */
@Repository("generalCodeDao")
public class GeneralCodeDaoImpl extends SupportDaoImpl<GeneralCode> implements GeneralCodeDao {
}

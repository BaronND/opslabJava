package app.service.impl;

import app.dao.BusinessLogDao;
import app.entries.BusinessLog;
import app.entries.EntryPage;
import app.service.BusinessLogService;
import app.service.sql.BusinessLogSQL;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("businessLogService")
public class BusinessLogServiceImpl extends SupportServiceImpl<BusinessLog> implements BusinessLogService {
	
	@Resource(name="businessLogDao")
	@Getter @Setter private BusinessLogDao dao;
	
	public EntryPage getPage(int page, int size){
		String hql =BusinessLogSQL.HQL_QUERY_PAGE;
		return dao.query(hql, page, size);
	}
}

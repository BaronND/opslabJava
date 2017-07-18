package app.service.impl;

import javax.annotation.Resource;

import app.exception.ServicesException;
import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Service;

import app.dao.TaskLogDao;
import app.entries.EntryPage;
import app.entries.TaskLog;
import app.service.TaskLogService;
import app.service.sql.TaskLogSQL;

@Service("taskLogService")
public class TaskLogServiceImpl extends SupportServiceImpl<TaskLog> implements TaskLogService{

	@Resource(name="taskLogDao")
	@Getter @Setter private TaskLogDao dao;

	public EntryPage getPage(int page, int size){
		String hql =TaskLogSQL.HQL_QUERY_PAGE;
		return dao.query(hql, page, size);
	}
}

package app.service;

import app.annotation.ServiceMethod;
import app.annotation.ServiceType;
import app.entries.EntryPage;
import app.entries.TaskLog;

public interface TaskLogService extends SupportService<TaskLog> {
	
	@ServiceMethod(type=ServiceType.SYSTEM,name="获取定时任务的执行日志")
	public EntryPage getPage(int page, int size);
	
}

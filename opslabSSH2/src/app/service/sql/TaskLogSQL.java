package app.service.sql;

public class TaskLogSQL {
	
	//查询定时任务执行日志的记录
	public static final String HQL_QUERY_PAGE =
			"FROM TaskLog t ORDER BY t.startTime desc";

}

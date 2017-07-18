package app.annotation;

public enum ServiceType {
	NONE,		//无
	SYSTEM,		//系统方法
	TOOLS,		//工具方法
	BUSINESS,	//业务方法
	INTERFACE,	//接口方法
	TASK_BUSINESS,//定时任务的业务方法
	TASK_TOOLS,//定时任务的工具方法
	TASK_SYSTEM,//定时任务的系统方法
	TASK_INTERFACE,//定时任务的接口方法
	TASK_NONE;	//一般的定时任务
}

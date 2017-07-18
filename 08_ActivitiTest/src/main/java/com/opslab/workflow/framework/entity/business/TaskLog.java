package com.opslab.workflow.framework.entity.business;

import java.util.Date;

public class TaskLog {

	//业务记录主键
	private String Id;
	
	//任务名称
	private String  taskName;
	
	//业务类型
	private String  taskType;
	
	//执行时间
	private Date   startTime;
	
	//实现类及方法
	private String  CodeId;
	
	//参数列表
	private String  Params;
	
	//执行结果
	private String  result;
	
	//附加信息
	private String  msg;

	@Override
	public String toString() {
		return "TaskLog [Id=" + Id + "]";
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getCodeId() {
		return CodeId;
	}

	public void setCodeId(String codeId) {
		CodeId = codeId;
	}

	public String getParams() {
		return Params;
	}

	public void setParams(String params) {
		Params = params;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}

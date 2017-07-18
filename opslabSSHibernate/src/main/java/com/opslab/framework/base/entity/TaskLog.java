package com.opslab.framework.base.entity;



import com.opslab.util.SysUtil;

import java.util.Date;

public class TaskLog {

	//业务记录主键
	private String id;

	//执行任务的主机IP
	private String ip;
	
	//任务名称
	private String  taskName;
	
	//业务类型
	private String  taskType;
	
	//执行时间
	private Date   startTime;
	
	//实现类及方法
	private String  operationName;
	
	//参数列表
	private String  operationParam;
	
	//执行结果
	private String  result;
	
	//附加信息
	private String  msg;

	public TaskLog() {
	}

	public TaskLog(String id) {
		this.id = id;
		this.ip = SysUtil.HOST_IP;
	}

	@Override
	public String toString() {
		return "TaskLog [Id=" + id + "]";
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getOperationParam() {
		return operationParam;
	}

	public void setOperationParam(String operationParam) {
		this.operationParam = operationParam;
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

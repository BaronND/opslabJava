package com.opslab.core.model;

import java.util.Date;

/**
 * 
 * @summary: 业务层的日志
 */
public class BusinessLog {

	private Date times;

	private String ip;

	private String port;

	private String className;

	private String level;

	private String msg;

	public Date getTimes() {
		return times;
	}

	public void setTimes(Date times) {
		this.times = times;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public BusinessLog(Date times, String ip, String port, String className, String level, String msg) {
		this.times = times;
		this.ip = ip;
		this.port = port;
		this.className = className;
		this.level = level;
		this.msg = msg;
	}

	public BusinessLog() {
	}
}

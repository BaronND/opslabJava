package com.opslab.system.model;

import java.util.Date;

/**
 * @summary: 业务层的日志
 */
public class BusinessLog {

    //主键ID
    private String id;

    //操作人
    private String userName;

    //操作开始时间
    private Date startTime = new Date();

    //操作结束时间
    private Date endTime = new Date();

    //业务层操作名称
    private String businessName;

    //业务层实现类及方法
    private String operationName;

    //操参数
    private String operationParam;

    //操作类型
    private String type;

    //操作结果
    private String result;

    //附件信息
    private String msg;

    public BusinessLog() {
    }

    public BusinessLog(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

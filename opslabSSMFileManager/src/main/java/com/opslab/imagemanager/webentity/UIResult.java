package com.opslab.imagemanager.webentity;

import java.util.Date;

/**
 * 返回统一的结果
 */
public class UIResult {
    private static String success = "SUCCESS";

    private static String error = "ERROR";

    private Date time;
    private String result;
    private String msg;
    private Object data;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public UIResult() {
    }

    public UIResult(String result, String msg) {
        this.time = new Date();
        this.result = result;
        this.msg = msg;
    }

    public UIResult(String result, String msg, Object data) {
        this.time = new Date();
        this.result = result;
        this.msg = msg;
        this.data = data;
    }

    public static UIResult success(String msg) {
        return new UIResult(success, msg);
    }

    public static UIResult success(String msg, Object data) {
        return new UIResult(success, msg, data);
    }

    public static UIResult error(String msg) {
        return new UIResult(error, msg);
    }

    public static UIResult error(String msg, Object data) {
        return new UIResult(error, msg, data);
    }
}

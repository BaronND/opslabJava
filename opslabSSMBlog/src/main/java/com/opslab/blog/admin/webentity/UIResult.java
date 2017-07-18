package com.opslab.blog.admin.webentity;

import com.opslab.blog.admin.APP;

import java.util.Date;

/**
 * 返回统一的结果
 */
public class UIResult {


    private long time;
    private String result;
    private String msg;
    private Object data;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
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
        this.time = System.currentTimeMillis();
        this.result = result;
        this.msg = msg;
    }

    public UIResult(String result, String msg, Object data) {
        this.time = System.currentTimeMillis();
        this.result = result;
        this.msg = msg;
        this.data = data;
    }

    public static UIResult success(String msg) {
        return new UIResult(APP.success, msg);
    }

    public static UIResult success(String msg, Object data) {
        return new UIResult(APP.success, msg, data);
    }

    public static UIResult error(String msg) {
        return new UIResult(APP.error, msg);
    }

    public static UIResult error(String msg, Object data) {
        return new UIResult(APP.error, msg, data);
    }

    /**
     * 根据影响的行数判断是否操作成功
     * @param count
     * @param successMsg
     * @param errorMsg
     * @return
     */
    public static UIResult notZero(int count,String successMsg,String errorMsg){
        if(count == 1){
            return UIResult.success(successMsg);
        }
        return UIResult.error(errorMsg);
    }
}

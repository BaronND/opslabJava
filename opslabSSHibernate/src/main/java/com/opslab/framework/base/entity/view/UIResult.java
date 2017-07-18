package com.opslab.framework.base.entity.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opslab.util.DateUtil;
import com.opslab.util.ExceptionUtil;

/**
 * @author 0opslab
 * @date on 2016/4/7 0007.
 * 用于为前台返回统一JSON格式的操作结果信息
 */
public class UIResult {
    @JsonProperty("result")
    private String result;

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("date")
    private String date;

    public UIResult(String result){
        this.result=result;
        this.msg="";
        this.date= DateUtil.currentDateTime();
    }

    public UIResult( String result,String msg) {
        this.msg = msg;
        this.result = result;
        this.date= DateUtil.currentDateTime();
    }

    public static UIResult success(){
        return new UIResult("success","操作成功");
    }

    public static UIResult error(Exception e){
        String msg = "操作失败:"+e.getMessage();
        return new UIResult("error",msg);
    }

    @Override
    public String toString() {
        return "{" +
                "result='" + result + '\'' +
                ", msg='" + msg + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

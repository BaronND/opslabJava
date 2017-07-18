package com.opslab.workflow.framework.entity.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opslab.DateUtil;

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

    @JsonProperty("dateTime")
    private String dateTime;

    public UIResult(String result){
        this.result=result;
        this.msg="";
        this.dateTime= DateUtil.DateTime();
    }

    public UIResult( String result,String msg) {
        this.msg = msg;
        this.result = result;
        this.dateTime= DateUtil.DateTime();
    }

    @Override
    public String toString() {
        return "{" +
                "result='" + result + '\'' +
                ", msg='" + msg + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}

package com.opslab.framework;


import com.opslab.APP;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 初始化一些查询页面的查询条件的默认值
 * 此处先使用类实现，后期使用数据配置的方式实现
 */
public class InitQuery {
    private final static SimpleDateFormat daySdf = new SimpleDateFormat(APP.DATE_DAY);
    public final static String logQueryStartTime(){
        return daySdf.format(new Date())+" 00:00:00";
    }

    public final static String logQueryEndTime(){
        return daySdf.format(new Date())+" 23:59:59";
    }
}

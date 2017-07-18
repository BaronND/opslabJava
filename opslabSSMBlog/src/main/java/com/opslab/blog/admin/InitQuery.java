package com.opslab.blog.admin;

import com.opslab.blog.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 初始化一些查询页面的查询条件的默认值此处先使用类实现，后期使用数据配置的方式实现
 */
public class InitQuery {
    //日期时间类型格式
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    //日期类型格式
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    //时间类型的格式
    private static final String TIME_FORMAT = "HH:mm:ss";

    /**
     * 查询开始时间
     * @return
     */
    public static String queryStartTime(){
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(DateUtil.day(new Date(),-30));
    }

    /**
     * 查询开始时间
     * @return
     */
    public static String queryEndTime(){
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(new Date())+" 23:59:59";
    }
}

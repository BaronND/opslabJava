package com.opslab.imagemanager;

import com.opslab.imagemanager.util.PropertiesUtil;

import java.io.File;

/**
 * 上传文件管理系统的一些常量
 */
public class APPManager {

    public static String CLASS_PATH = APPManager.class.getClassLoader().getResource("").getPath();

    public static String PACKAGE_NAME = "com.opslab.imagemanager";

    /*上传的基础路径*/
    public static String UPLOAD_BASE_PATH = PropertiesUtil.GetValueByKey(CLASS_PATH+"/imagemanager.properties","upload_base_path");


    /*非法文件保存*/
    public static String ILLEGAL_PATH = UPLOAD_BASE_PATH + File.separator+ "illegal";

    /*状态有效*/
    public static String STATUS_VALID = "1";

    /*状态无效*/
    public static String STATUS_Invalid ="0";
}

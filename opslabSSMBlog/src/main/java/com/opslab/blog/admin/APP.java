package com.opslab.blog.admin;

import java.io.File;

/**
 * 定义系统的一些常量
 */
public class APP {

    public static String CLASS_PATH = APP.class.getClassLoader().getResource("").getPath();

    public static String PACKAGE_NAME = "com.opslab.blog";

    /*上传的基础路径*/
    public static String UPLOAD_BASE_PATH = "c:/tmp/uploadfile";


    /*非法文件保存*/
    public static String ILLEGAL_PATH = UPLOAD_BASE_PATH + File.separator + "illegal";

    //成功
    public static String success = "success";

    //失败
    public static String error = "error";

    //异常
    public static String exception = "exception";


    /*状态有效*/
    public static String STATUS_VALID = "1";

    /*状态无效*/
    public static String STATUS_INVALID = "0";

    //树形关系的根节点
    public static String TREE_TYPE_ROOT = "ROOT";

    //树形关系的目录节点
    public static String TREE_TYPE_BRANCH = "BRANCH";

    //树形关系的叶子节点
    public static String TREE_TYPE_LEAF = "LEAF";

    //定义分页大小
    public static int APP_PAGESIZE = 20;
}

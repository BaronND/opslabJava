package com.opslab.imagemanager.domain;

/**
 * 上传文件的状态
 */
public class UploadInfoStatus {
    //上传文件
    public static int UPLOAD_STATUS_CREATE = 0;

    //上传文件成功
    public static int UPLOAD_STATUS_SUCCESS = 1;

    //上传文件失败
    public static int UPLOAD_STATUS_ERROR = 2;

    //上传文件为非法文件
    public static int UPLOAD_STATUS_ILLEGAL = 3;

    //软删除文件
    public static int UPLOAD_STATUS_REMOVE = 4;

    //硬删除文件
    public static int UPLOAD_STATUS_DELETE = 5;
}

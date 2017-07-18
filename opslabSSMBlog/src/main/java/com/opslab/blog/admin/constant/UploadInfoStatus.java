package com.opslab.blog.admin.constant;

/**
 * 上传文件的状态
 */
public enum  UploadInfoStatus {

    //上传文件
    CREATE,

    //上传文件成功
    SUCCESS,

    //上传文件失败
    ERROR,

    //上传文件为非法文件
    ILLEGAL,

    //软删除文件
    REMOVE,

    //硬删除文件
    DELETE
}

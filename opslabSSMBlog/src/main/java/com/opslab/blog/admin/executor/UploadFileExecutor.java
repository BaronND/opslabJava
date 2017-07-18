package com.opslab.blog.admin.executor;

import java.io.File;

/**
 * 处理上传后的图片
 */
public interface UploadFileExecutor {

    /**
     * 处理上传后的文件
     */
    void hand(File file);
}

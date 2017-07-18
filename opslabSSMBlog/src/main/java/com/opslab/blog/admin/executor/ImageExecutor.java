package com.opslab.blog.admin.executor;

import java.io.File;

/**
 * @author 0opslab
 * @descript 用户添加处理图片
 */
public interface ImageExecutor {
    /**
     * 处理上传后的文件
     */
    void hand(File file);
}

package com.opslab.imagemanager.executor;

import com.opslab.imagemanager.domain.UploadGroupHandler;

import java.util.List;

/**
 * 用于处理图片的线程池
 */
public interface ImageExecutor {
    /**
     * 对原始图像执行一组处理
     * @param file
     * @param handlerList
     */
    void handler(String file, List<UploadGroupHandler> handlerList);
}

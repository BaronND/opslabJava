package com.opslab.imagemanager.executor;

import com.opslab.imagemanager.domain.UploadGroupHandler;

import java.util.List;

/**
 * Created by neptune on 2017/4/4 0004.
 */
public interface FileExecutor {
    /**
     * 对原始图像执行一组处理
     * @param file
     * @param handlerList
     */
    void handler(String file, List<UploadGroupHandler> handlerList);
}

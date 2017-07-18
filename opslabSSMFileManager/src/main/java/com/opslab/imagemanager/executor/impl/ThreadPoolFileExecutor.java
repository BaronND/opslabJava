package com.opslab.imagemanager.executor.impl;

import com.opslab.imagemanager.domain.UploadGroupHandler;
import com.opslab.imagemanager.executor.FileExecutor;
import com.opslab.imagemanager.util.JacksonUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 上传文件处理
 */
@Component
public class ThreadPoolFileExecutor implements FileExecutor{
    private static Logger logger = LogManager.getLogger(ThreadPoolFileExecutor.class);
    @Override
    public void handler(String file, List<UploadGroupHandler> handlerList) {
        logger.debug(file+":"+ JacksonUtil.toJSON(handlerList));
    }
}

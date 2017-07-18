package com.opslab.blog.admin.executor.impl;

import com.opslab.blog.admin.executor.ImageExecutor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author 0opslab
 * @descript 请添加说明
 */
@Component
public class ImageExcutorImpl implements ImageExecutor {
    private static Logger logger = LogManager.getLogger(ImageExcutorImpl.class);

    @Override
    public void hand(File file) {
        logger.info("处理图片");
    }
}

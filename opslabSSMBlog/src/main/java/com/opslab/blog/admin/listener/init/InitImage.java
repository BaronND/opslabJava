package com.opslab.blog.admin.listener.init;

import com.opslab.blog.admin.APP;
import com.opslab.blog.util.FileUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * 根据配置文件初始化ImageGroup
 */
public class InitImage {
    private static Logger logger = LogManager.getLogger(InitImage.class);


    /**
     * 初始化图片上组相关的信息
     */
    public static void init(){
        String illegal_path = FileUtil.path(APP.UPLOAD_BASE_PATH);
        File illegalPath = new File(illegal_path);
        if(illegalPath.exists()){
            logger.info("path exists:"+illegal_path);
        }else{
            logger.info("creating path:"+illegal_path);
            illegalPath.mkdir();
        }
    }
}

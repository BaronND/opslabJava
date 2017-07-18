package com.opslab.imagemanager.listener.init;

import com.opslab.imagemanager.APPManager;
import com.opslab.imagemanager.domain.UploadGroup;
import com.opslab.imagemanager.domain.UploadGroupHandler;
import com.opslab.imagemanager.service.UploadGroupService;
import com.opslab.imagemanager.util.FileUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.List;

/**
 * 根据配置文件初始化ImageGroup
 */
public class InitImageGroup {
    private static Logger logger = LogManager.getLogger(InitImageGroup.class);
    /**
     * 初始化图片上传组上传的目录
     * @param group
     * @param basePath
     */
    public static void initImageGroupUploadPath(UploadGroup group, String basePath){
        if(group == null){
            return;
        }
        String group_path = FileUtil.path(basePath + File.separator+ group.getPath());
        File groupPath = new File(group_path);
        if(groupPath.exists()){
           logger.info("path exists:"+group_path);
        }else{
            logger.info("creating path:"+group_path);
            groupPath.mkdir();
        }

        //元文件保存路径
        String original_Path = FileUtil.path(groupPath + File.separator+ group.getOriginalPath());
        File originalPath = new File(original_Path);
        if(originalPath.exists()){
            logger.info("path exists:"+original_Path);
        }else{
            logger.info("creating path:"+original_Path);
            originalPath.mkdir();
        }

        //处理组
        List<UploadGroupHandler> handlerList = group.getHandlers();
        if(handlerList == null && handlerList.size() == 0){
            return;
        }
        for(UploadGroupHandler handler:handlerList){
            String handler_path = FileUtil.path(group_path + File.separator+ handler.getPath());
            File handlerPath = new File(handler_path);
            if(handlerPath.exists()){
                logger.info("path exists:"+handler_path);
            }else{
                logger.info("creating path:"+handler_path);
                handlerPath.mkdir();
            }
        }
    }

    /**
     * 初始化图片上组相关的信息
     * @param service
     */
    public static void init(UploadGroupService service){
        if(service == null){
            logger.error("ImageGroupService init error....");
            return;
        }
        String illegal_path = FileUtil.path(APPManager.ILLEGAL_PATH);
        File illegalPath = new File(illegal_path);
        if(illegalPath.exists()){
            logger.info("path exists:"+illegal_path);
        }else{
            logger.info("creating path:"+illegal_path);
            illegalPath.mkdir();
        }
        List<UploadGroup> list = service.list();
        if(list != null && list.size() > 0){
            for(UploadGroup group:list){
                initImageGroupUploadPath(group, APPManager.UPLOAD_BASE_PATH);
            }
        }
    }
}

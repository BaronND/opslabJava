package com.opslab.imagemanager.executor.impl;

import com.opslab.imagemanager.domain.UploadGroupHandler;
import com.opslab.imagemanager.executor.ImageExecutor;
import com.opslab.imagemanager.util.JacksonUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.*;

/**
 * 利用线程池对图像进行一组处理
 */
@Component
public class ThreadPoolImageExecutor implements ImageExecutor{
    @Override
    public void handler(String file, List<UploadGroupHandler> handlerList) {
        System.out.println(file +" => " + JacksonUtil.toJSON(handlerList));
    }
//    private static BlockingQueue queue = new LinkedBlockingQueue(10);;
//
//
//    public static class ImageExecutorTask{
//        private String file;
//        private List<UploadGroupHandler> handlerList;
//
//        public ImageExecutorTask(String file, List<UploadGroupHandler> handlerList) {
//            this.file = file;
//            this.handlerList = handlerList;
//        }
//
//        public String getFile() {
//            return file;
//        }
//
//        public void setFile(String file) {
//            this.file = file;
//        }
//
//        public List<UploadGroupHandler> getHandlerList() {
//            return handlerList;
//        }
//
//        public void setHandlerList(List<UploadGroupHandler> handlerList) {
//            this.handlerList = handlerList;
//        }
//    }
//    @Override
//    public void handler(String file, List<UploadGroupHandler> handlerList) {
//
//        queue.add(new ImageExecutorTask(file,handlerList));
//    }
//
//    public ThreadPoolImageExecutor() {
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//        /**
//         * 每2秒大于一次
//         */
//        scheduledExecutorService.scheduleAtFixedRate(new ImageExecutor(queue),1,2, TimeUnit.SECONDS);
//    }
//
//    public static class ImageExecutor implements Runnable{
//        private static Logger logger = LogManager.getLogger(ImageExecutor.class);
//        private BlockingQueue queue;
//
//        public ImageExecutor(BlockingQueue queue) {
//            this.queue = queue;
//        }
//
//        @Override
//        public void run() {
//            if (queue != null && queue.size() > 0){
//                try {
//                    ImageExecutorTask task = (ImageExecutorTask)queue.take();
//                    String file = task.getFile();
//                    List<UploadGroupHandler> handlerList  = task.getHandlerList();
//                    if(handlerList == null || handlerList.size() == 0){
//                        return;
//                    }
//                    for(UploadGroupHandler handler:handlerList){
//                        logger.info(JacksonUtil.toJSON(handler) +" ===> " + file);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
//    }
}

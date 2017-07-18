package com.opslab.blog.admin.executor.impl;

import com.opslab.blog.admin.executor.UploadFileExecutor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * 上传文件处理
 */
@Component
public class ThreadPoolUploadFileExecutor implements UploadFileExecutor {
    private static Logger logger = LogManager.getLogger(ThreadPoolUploadFileExecutor.class);


    @Override
    public void hand(File file) {
        logger.info("hand file:"+file.getName());
        //queue.add(new UploadFileExecutorTask(file));
    }

//    private static BlockingQueue queue = new LinkedBlockingQueue(10);;
//
//
//    public static class UploadFileExecutorTask {
//        private static Logger logger = LogManager.getLogger(UploadFileExecutorTask.class);
//        private File file;
//
//        public UploadFileExecutorTask(File file) {
//            this.file = file;
//        }
//
//        public File getFile() {
//            return file;
//        }
//
//        public void setFile(File file) {
//            this.file = file;
//        }
//
//        public void hand(){
//            logger.info("hand file:"+this.file.getName());
//        }
//    }
//
//
//
//    public ThreadPoolUploadFileExecutor() {
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//        /**
//         * 每2秒大于一次
//         */
//        scheduledExecutorService.scheduleAtFixedRate(new ImageExecutor(queue),1,2, TimeUnit.SECONDS);
//    }
//
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
//                    UploadFileExecutorTask task = (UploadFileExecutorTask)queue.take();
//                    task.hand();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
//    }
}

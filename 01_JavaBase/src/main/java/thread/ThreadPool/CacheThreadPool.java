package thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 缓存线程池
 */
public class CacheThreadPool implements Runnable{
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 5; i++) {
            System.out.println(name+":线程在运行!");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建缓存线程池
        ExecutorService executorService =  Executors.newCachedThreadPool();


        FixedThreadPool task = new FixedThreadPool();
        for (int i = 0; i < 10; i++) {
            //向线程池中提交任务
            executorService.submit(task);
            Thread.sleep(250);
        }

    }
}

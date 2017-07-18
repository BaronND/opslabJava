package thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定线程池数量
 */
public class FixedThreadPool implements Runnable {
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

    public static void main(String[] args) {
        //创建固定大小的线程池
        ExecutorService executorService =  Executors.newFixedThreadPool(5);


        FixedThreadPool task = new FixedThreadPool();
        for (int i = 0; i < 10; i++) {
            //向线程池中提交任务
            executorService.submit(task);
        }

    }
}

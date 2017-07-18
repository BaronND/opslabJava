package thread.ThreadDemo;

import java.util.concurrent.Semaphore;

/**
 * 信号量为多线程提供了更为强大的控制方法
 *
 * semaphore主要有如下方法
 *   Semaphore(int permits) //构造方法指定同时多个许可
 *   Semaphore(int permits,boolean fair) //是否公平的构造方法
 *
 *   acquire() 尝试获取一个许可,若无法获取到则继续瞪大
 *   acquireUniterruptibly() 和acquire方法相同但是不会响应中单
 *   tryAcquire() 尝试获取一个锁,不会进行等待如果成功返回true否则返回false
 *   release() 用于在线程访问资源结束后,释放一个许可
 */
public class SemaphoreDemo implements Runnable{
    private int tasks;
    private Semaphore semaphore;

    public SemaphoreDemo(int task,Semaphore semaphore){
        this.tasks = task;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(this.tasks+"使用一个信号许可");
            Thread.sleep(10000);
            System.out.println(this.tasks+"释放一个信号许可");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        /**
         * 以下操作类似10个工人只有5台设备，意味着同时只能有5个人工作一样
         */
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SemaphoreDemo(i, semaphore));
            thread.start();
            if(i % 2 == 0){
                thread.interrupted();
            }
        }
    }
}

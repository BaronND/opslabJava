package thread.ThreadDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁
 *      相比synchronized重入锁可以需要手动获取锁和释放锁，因此相比起来更加灵活
 * ReentrankLock 的几个重要方法
 *     lock()   获得锁,如果锁已经被占用，则等待
 *     lockInterruptibly()  获得锁，但优先响应中断
 *     tryLock() 尝试获得锁，如果成功返回true，失败返回false
 *     tryLock(long time,TimeUtil unit) 尝试获取锁，设定超时时间
 *     unlock() 释放锁
 */
public class LockDemo implements Runnable{

    //定义一个锁
    public static ReentrantLock lock = new ReentrantLock();

    public static int count = 0;
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            //获取锁
            lock.lock();
            try{
                count++;
            }finally {
                //无论如何都释放锁
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockDemo lockDemo = new LockDemo();


        Thread thread = new Thread(lockDemo);
        Thread thread1 = new Thread(lockDemo);

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(count);
    }
}

package thread.ThreadDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition主要和重入锁一起使用,就想wait和notify方法与synchronized一起使用一样
 * Condition主要的方法有
 * await  会使当前线程等待,并同时释放当前的锁,当其他线程使用signal或者signalAll方法线程会重新去获取锁并继续执行
 * 或者当前线程被中断时,也能跳出等待
 * awaitUniterruptibly 会使当前线程进入等待，但是他并不会对中断做错响应
 * <p>
 * signal 方法用户唤醒一个等待的线程
 * <p>
 * <p>
 * 注意:
 * 不论是调用await方法还是signal方法都需要拥有相应对象的的锁
 */
public class ConditionDemo implements Runnable {
    public static ReentrantLock lock = new ReentrantLock(true);
    public static Condition condition = lock.newCondition();


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            lock.lock();
            System.out.println(name + ":线程开始运行");

            //使线程进入等待状态
            condition.await();

            System.out.println(name+ ":线程继续运行");
            Thread.sleep(5000);
            System.out.println(name + ":执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("锁释放");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionDemo conditionDemo = new ConditionDemo();
        Thread thread = new Thread(conditionDemo);
        thread.start();
        Thread.sleep(2000);

        //唤起线程,注意需要获取到锁后才能去唤醒
        lock.lock();
        condition.signalAll();
        lock.unlock();

        thread.join();
    }
}

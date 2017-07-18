package thread.ThreadDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁除了能自由的获取锁以外，还可以除了中断响应
 */
public class LockAdvancedDemo implements Runnable{

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();

    private  int count ;

    public LockAdvancedDemo(int count){
        this.count = count;
    }


    @Override
    public void run() {
        try {
            if (count == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(5000);
                System.out.println("代码块1执行");
                lock2.lockInterruptibly();
                System.out.println("代码块1执行完毕");
            } else {
                lock2.lockInterruptibly();
                Thread.sleep(5000);
                System.out.println("代码块2执行");
                lock1.lockInterruptibly();
                System.out.println("代码块2执行完毕");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lock1.isHeldByCurrentThread())
                lock1.unlock();
            if(lock2.isHeldByCurrentThread())
                lock2.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new LockAdvancedDemo(1));
        Thread thread1 = new Thread(new LockAdvancedDemo(0));

        thread.start();
        thread1.start();


        //如果只是按照上面的方式调用，那么会进入死锁的状态
        //thread线程启动后获取lock1 thread1启动后获取lock2 继续执行是需要获取别的锁，而别的锁刚好被别的线程拥有所以会死锁
        //此时可以中断其中一个线程
        thread1.interrupt();
    }
}

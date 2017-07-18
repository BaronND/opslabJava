package thread.ThreadDemo;

import java.util.concurrent.CountDownLatch;

/**
 * 到计时器
 *  这个工具通常用来控制等待,它可以让某一个线程等待直到倒计时结束，再开始执行
 *  例如所以检查工作完成后，再执行
 *
 *  CountDownLatch主要的方法有
 *      CountDownLatch(int count) 构造器
 *      await() 等待直到count计数器为0是才执行
 *      boolean await(long Timeout,TimeUnit unit) 尝试等待一定的时候count值还没变0的话就会执行
 *      countDown()// count计数器减1
 */
public class CountDownLatchDemo {
    static  CountDownLatch countDownLatch = new CountDownLatch(10);
    public static void main(String[] args) throws InterruptedException {


        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("当前计数器:"+countDownLatch.getCount());
                }

            }
        }.start();

        System.out.println("主线程即将被挂机,直到倒计时器为0才开始执行!");
        countDownLatch.await();

        System.out.println("主线程继续执行");
        Thread.sleep(2000);
        System.out.println("主线程执行结束");
    }
}

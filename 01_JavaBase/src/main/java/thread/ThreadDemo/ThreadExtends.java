package thread.ThreadDemo;

import java.util.Date;


/**
 * 演示以继承Thread方式实现多线程的例子
 */
public class ThreadExtends extends Thread {
    /**
     * 通过覆写Thread的run方法实现线程的主体
     */
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(Thread.currentThread().getName() + "\t");
            System.out.println(new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new ThreadExtends();
        System.out.println(Thread.currentThread().getName());
        //start Thread
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }
}

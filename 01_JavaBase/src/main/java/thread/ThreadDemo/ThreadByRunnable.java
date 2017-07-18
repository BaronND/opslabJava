package thread.ThreadDemo;

import java.util.Date;

/*****************************************************
 *
 * @summary 演示通过实现Runnable接口实现多线程程序
 *****************************************************/
public class ThreadByRunnable implements Runnable {

    /**
     * 实现接口的方法
     */
    @Override
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
        Thread thread = new Thread(new ThreadByRunnable());
        System.out.println(Thread.currentThread().getName());
        //start Thread
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }
}

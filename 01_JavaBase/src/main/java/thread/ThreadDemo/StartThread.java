package thread.ThreadDemo;


/**
 * 线程的基础方法
 */
public class StartThread {



    public static void main(String[] args) throws InterruptedException {
        /**
         * 新建线程 使用new创建一个线程对象，并调用它的start()方法，注意不要调用run方法
         * 调用run方法和调用普通的方法没有区别
         */
        Thread th1 = new Thread(new ThreadByRunnable());
        Thread th2 = new ThreadExtends();

        /**
         * Thread.sleep 可以当前线程执行暂停一个时间段，这样处理器时间就可以给其他线程使用。
         * sleep 有两种重载形式：一个是指定睡眠时间到毫秒，另外一个是指定的睡眠时间为纳秒级
         *
         */
        th1.start();
        Thread.sleep(1000 * 11);
        System.out.println("---");
        th1.start();
        Thread.sleep(1000 * 11);
        System.out.println("---");
        th2.start();
        Thread.sleep(1000 * 11);
        System.out.println("---");
        th2.start();


        Thread thread = new Thread(new ThreadByRunnable());
        thread.start();

        /**
         * join 方法允许一个线程等待另一个完成。假设 t 是一个 Thread 对象
         * 它会导致当前线程暂停执行直到 t 线程终止。join 允许程序员指定一个等待周期
         */
        thread.join();
        System.out.println("执行完成!");


        /**
         * sleep 和 join 都会被打断，并抛出InterruptedException 异常
         */
    }


}

package thread;

/**
 * @author 0opslab
 * UncaughtExceptionHandler从字面上来看是“未捕获的异常处理”
 * <p>
 * 这个命名有些迷惑人，实际上大家看源码就知道uncaughtException(Thread t, Throwable e )入参是Throwable接口，
 * 所以java.lang.Error和java.lang.Exception都会捕获。同时因为工程对其他中心或是项目引用比较多，经常会有java.
 * lang.NoClassDefFoundError: Could not initialize class等类似问题，所以try catch的时候捕获Throwable
 * 比较好
 * 结束语：鉴于上述知识点，建议将所有重要子线程设置UncaughtExceptionHandler，在主线程获取子线程日志，否则有问题子
 * 线程内部未捕获，有问题将会石沉大海，无法定位。
 */

/***
 * 当线程异常后当前线程会推出里面下面线程
 */
class Task implements Runnable {
    @Override
    public void run() {
        System.out.println(Integer.parseInt("1111"));
        System.out.println(Integer.parseInt("2222"));
        System.out.println(Integer.parseInt("3333"));
        //此处会抛出异常线程会直接推出后续的俩行代码将不会被执行
        //试想当一个线程处理大量这样的数据但遇到异常后后续的数据将不能处理，这是常规线程所不能做到的
        System.out.println(Integer.parseInt("XXXX"));
        System.out.println(Integer.parseInt("4444"));
        System.out.println(Integer.parseInt("5555"));
    }
}

/**
 * 荣线程集成UncaughtExceptionHandler来处理未捕获的任何异常
 */
class ThreadException implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        String msg = String.format("thread %s error! Exception(%s):%s",
                t.getId(), t.getClass().getName(), e.getMessage());
        System.out.println(msg);
        System.out.printf("Stack Trace: n");
        //遇到异常后重启一个线程继续处理
        new Thread(new SupportTask()).start();
    }
}

class SupportTask implements Runnable {

    @Override
    public void run() {
        //设置线程异常处理
        Thread.currentThread().setUncaughtExceptionHandler(new ThreadException());

        String result = "Thread %d => %d";
        Long threadId = Thread.currentThread().getId();
        System.out.println(String.format(result, threadId, Integer.parseInt("1111")));
        System.out.println(String.format(result, threadId, Integer.parseInt("2222")));
        System.out.println(String.format(result, threadId, Integer.parseInt("3333")));
        //此处会抛出异常线程会直接推出后续的俩行代码将不会被执行
        //但是此处设置了异常处理后因此获新启动一个线程进行处理
        //注意新启动的线程会继续从头开始（据说通过切换线程上线文可以设置以便跳过已经完成的任务去完成未完成的任务）
        //但是鄙人目前还不会如何设置线程上下文
        //当时可以修改线程的实现方式通过队列等数据结构有效扼解决此类问题
        //从队列中去除数据并处理，遇到使程序异常的数据可以通过异常处理类ThreadException存储起来
        //等异常处理类启动新线程的时候队列中的脏数据以前别去除并记录到日志中
        //因此可以继续运行
        System.out.println(String.format(result, threadId, Integer.parseInt("XXXX")));
        System.out.println(String.format(result, threadId, Integer.parseInt("4444")));
        System.out.println(String.format(result, threadId, Integer.parseInt("5555")));

    }


}

public class UncaughtExceptionHandlerDemo {
    public static void main(String[] args) {
        new Thread(new Task()).start();

        new Thread(new SupportTask()).start();
    }
}

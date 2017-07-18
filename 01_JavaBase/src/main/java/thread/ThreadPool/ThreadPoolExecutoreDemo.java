package thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 创建自定义的线程池
 */
public class ThreadPoolExecutoreDemo implements Runnable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThreadPoolExecutoreDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+":正在执行");
    }

    public static void main(String[] args) {

        //创建自定义的线程池
        ExecutorService executorService = new ThreadPoolExecutor(
                5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {

                System.out.println("准备执行:"+((ThreadPoolExecutoreDemo)r).getName());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行结束:"+((ThreadPoolExecutoreDemo)r).getName());
            }

            @Override
            protected void terminated() {
                System.out.println("线程池关闭");
            }
        };


        //向线程池提交任务
        for (int i = 0; i < 5; i++) {
            executorService.execute(new ThreadPoolExecutoreDemo("任务"+i));
        }


        //关闭线程池
        executorService.shutdown();
    }
}

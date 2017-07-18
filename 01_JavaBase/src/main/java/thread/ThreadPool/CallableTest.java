package thread.ThreadPool;

import java.util.concurrent.*;

/**
 * 测试Callable
 */
public class CallableTest {
    public static class Task implements Callable<Long>{

        @Override
        public Long call() throws Exception {
            System.out.println("子线程计算中");
            Long sum = 0L;
            for (int i = 0; i < 10000; i++) {
                sum += i;
            }
            return sum;
        }
    }

    /**
     * 创建线程池并执行相应的任务
     * 注意俩种执行任务的方式以及获取结果的方法
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * 创建线程池
         */
        ExecutorService executorService =  Executors.newCachedThreadPool();
        Task task = new Task();

        /**
         * 直接将Callable实例传给线程池
         */
        Future<Long> submit = executorService.submit(task);
        Long sum = submit.get();

        System.out.println("计算结果为:"+sum);

        /**
         * 将任务分装成FutureTask再提交
         */
        FutureTask<Long> taskFutureTask = new FutureTask<Long>(task);
        executorService.submit(taskFutureTask);

        Long sum1 = taskFutureTask.get();
        System.out.println("计算结果为:"+sum1);

        executorService.shutdown();

    }
}

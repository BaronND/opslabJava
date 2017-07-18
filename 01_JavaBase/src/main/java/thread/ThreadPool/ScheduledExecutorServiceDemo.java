package thread.ThreadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduleExecutorService线程池
 */
public class ScheduledExecutorServiceDemo implements Runnable {
    private String name;

    @Override
    public void run() {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        System.out.println(name + ":线程开始执行" + sdf.format(new Date()));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public ScheduledExecutorServiceDemo(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);


        //1秒后执行该任务
        ScheduledExecutorServiceDemo task1 =
                new ScheduledExecutorServiceDemo("只执行一次任务");
        scheduledExecutorService.schedule(task1, 1, TimeUnit.DAYS.SECONDS);


        //5秒后开始每十秒调用一次该任务
        ScheduledExecutorServiceDemo task2 =
                new ScheduledExecutorServiceDemo("固定周期任务");
        scheduledExecutorService.scheduleAtFixedRate(task2, 5, 2, TimeUnit.SECONDS);

        //5秒后在上一个任务完成的基础上开始每十秒调用一次该任务
        ScheduledExecutorServiceDemo task3 =
                new ScheduledExecutorServiceDemo("保证上次任务完成的基础上固定周期任务");
        scheduledExecutorService.scheduleWithFixedDelay(task3, 5, 2, TimeUnit.SECONDS);
    }


}

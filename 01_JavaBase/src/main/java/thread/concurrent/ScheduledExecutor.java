package thread.concurrent;

/**
 * Created by 0opslab
 * 线程任务
 */
public class ScheduledExecutor implements Runnable{
    private String jobName;

    public void run() {
        System.out.println(jobName + "is running");
    }

    public ScheduledExecutor() {
    }

    public ScheduledExecutor(String jobName) {
        this.jobName = jobName;
    }
}

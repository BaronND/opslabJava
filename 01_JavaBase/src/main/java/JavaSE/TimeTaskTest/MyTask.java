package JavaSE.TimeTaskTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTask extends TimerTask {
    public void run() {
        SimpleDateFormat sdf = null;
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println("current-time:" + sdf.format(new Date()));
    }

    public static void main(String[] args) {
        Timer t = new Timer();
        MyTask mytask = new MyTask();

        //涓€绉掑悗寮€濮?姣?绉掗吨澶崭竴娆?
        t.schedule(mytask, 1000, 2000);
    }
}
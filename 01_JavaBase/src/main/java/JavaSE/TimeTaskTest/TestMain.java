package JavaSE.TimeTaskTest;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class TestMain {

    public static void main(String[] args) {

        Timer timer = new Timer();
        Task task = new Task();
        Calendar dar = Calendar.getInstance();

        dar.set(Calendar.HOUR_OF_DAY, 18);
        dar.set(Calendar.MINUTE, 10);
        dar.set(Calendar.SECOND, 0);
        Date startTime = dar.getTime();
        System.out.println(startTime);
        timer.scheduleAtFixedRate(task, startTime, 1000 * 5);

    }

}

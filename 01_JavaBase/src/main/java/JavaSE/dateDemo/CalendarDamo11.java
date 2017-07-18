package JavaSE.dateDemo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class CalendarDamo11 {

    public static void main(String[] args) {

        Calendar dar = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai");
        sdf.setTimeZone(timezone);
        System.out.println(sdf.format(dar.getTime()));

        dar.add(Calendar.HOUR_OF_DAY, -1);
        System.out.println(sdf.format(dar.getTime()));
    }

}

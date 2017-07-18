package JavaSE.dateDemo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class CalenCarDemo {

    public static void main(String[] args) {

        Calendar dar = Calendar.getInstance();
        TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai");
        dar.setTimeZone(timezone);
        dar.add(Calendar.HOUR, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Count_data = sdf.format(dar.getTime());
        dar.add(Calendar.MINUTE, 4);
        dar.add(Calendar.SECOND, 10);
        String Toplimit_time = sdf.format(dar.getTime());
        dar.add(Calendar.MINUTE, 5);
        dar.add(Calendar.DAY_OF_MONTH, -1);
        String LowerLimit_time = sdf.format(dar.getTime());
        System.out.println(Count_data);
        System.out.println(Toplimit_time);
        System.out.println(LowerLimit_time);
    }

}

package JavaSE.dateDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CurrentHour {

    /**
     * @param args
     */


    public static void main(String[] args) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH");
        TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai");
        sdf1.setTimeZone(timezone);
        String str_time = sdf1.format(new Date());
        System.out.println(str_time);
    }

}

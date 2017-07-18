package JavaSE.Time;

import java.text.DateFormat;
import java.util.Date;

public class dateFormat {
    public static void main(String[] args) {
        DateFormat date = null;
        DateFormat dateTime = null;

        date = DateFormat.getDateInstance();
        dateTime = DateFormat.getDateTimeInstance();
        System.out.println("DATE:" + date.format(new Date()));
        System.out.println("DateTime:" + dateTime.format(new Date()));
    }
}
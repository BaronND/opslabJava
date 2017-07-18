package JavaSE.Time;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calendar_getTime {
    public static void main(String[] args) {
        Calendar cal = null;
        cal = new GregorianCalendar();
        System.out.println(" YEAR:" + cal.get(Calendar.YEAR));
        System.out.println(" MONTH:" + cal.get(Calendar.MONTH));
        System.out.println(" DAY_OF_MONTH:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(" HOUR_OF_DAY:" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(" MINUTE:" + cal.get(Calendar.MINUTE));
        System.out.println(" SECOND:" + cal.get(Calendar.SECOND));
        System.out.println(" MILLISECOND:" + cal.get(Calendar.MILLISECOND));
    }
}
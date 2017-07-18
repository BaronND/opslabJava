package JavaSE.Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class simpleDateFormat {
    public static void main(String[] args) {
        String str = "2009-10-19 10:11:30.345";

        String pat1 = "yyyy-MM-dd HH:mm:ssSSS";
        String pat2 = "yyyyMM月dd日 HH时mm分ss秒SSS毫秒";

        SimpleDateFormat sdf1 = new SimpleDateFormat(pat1);
        SimpleDateFormat sdf2 = new SimpleDateFormat(pat2);

        Date d = null;
        try {
            d = sdf1.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(sdf2.format(d));

    }
}
package JavaSE.dateDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleData {

    public static void main(String[] args) {

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf1.format(new Date()).substring(0, 13) + ":00:00");
    }

}

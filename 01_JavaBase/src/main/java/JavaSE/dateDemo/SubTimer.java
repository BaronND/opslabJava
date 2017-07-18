package JavaSE.dateDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SubTimer {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH24:mm:ss");
        String str_time = sdf.format(new Date());
        System.out.println("yyyy-MM-dd>" + str_time.substring(0, 10) + ".");
        System.out.println("HH>" + str_time.substring(11, 13) + ".");
        System.out.println("dd>" + str_time.substring(8, 13) + ".");
        System.out.println("MM>" + str_time.substring(5, 13) + ".");
        for (int i = 0; i < 4; i++) {
            System.out.println("11111111");
        }

    }

}

package JavaIO.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class demo3 {

    public static void main(String[] args) throws ParseException {

        Scanner scan = new Scanner(System.in);

        System.out.println("请输入一个日期： yyyy-MM-dd");

        if (scan.hasNext("^\\d{4}-\\d{2}-\\d{2}$")) {
            String str = scan.next("^\\d{4}-\\d{2}-\\d{2}$");
            Date date = (new SimpleDateFormat("yyyy-MM-dd")).parse(str);
            System.out.println(date);
        } else {
            System.out.println("输入有误，请确定你的输入格式");
        }

        scan.close();
    }

}

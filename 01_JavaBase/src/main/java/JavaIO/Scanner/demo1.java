package JavaIO.Scanner;

import java.util.Scanner;

public class demo1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = null;
        System.out.println("请输入数据");
        str = scan.next();
        System.out.println("你输入的数据为:" + str);

        scan.close();
    }

}

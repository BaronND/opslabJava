package JavaIO.Scanner;

import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("请输入整数：");
        int i = 0;
        if (scan.hasNextInt()) {
            i = scan.nextInt();
            System.out.println("你输入的整数为:" + i);
        } else {
            System.out.println("输入有误 请确定你的输入");
        }

        scan.close();
    }

}

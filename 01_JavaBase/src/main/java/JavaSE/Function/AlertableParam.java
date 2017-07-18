package JavaSE.Function;

public class AlertableParam {

    public static void main(String[] agrs) {
        System.out.println("演示JDK1.5以后的可变参数的函数定义");

        System.out.println("不传参数的调用");
        printStr();

        System.out.println("传递三个参数调用");
        printStr("I", "Love", "You");


    }


    public static void printStr(String... strings) {
        System.out.println("该次函数调用传递了" + strings.length + "个参数");
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + " ");
        }
        System.out.println();
    }
}

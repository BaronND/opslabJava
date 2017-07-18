package JavaIO.System;

import java.io.IOException;

public class InputKeyDemo {

    public static void main(String[] args) throws IOException {

        InputKey in = new InputKey("请输入数据");
        System.out.println("请输入一个字符串:" + in.getString());
        System.out.println("请输入一个整数:" + in.getInt("你确定你的输入"));
        System.out.println("请输入一个浮点数:" + in.getFloat("请数据浮点数"));
        System.out.println("请输入一个字符串:" + in.getDate("请输入日期：yyyy-MM-dd"));

    }

}

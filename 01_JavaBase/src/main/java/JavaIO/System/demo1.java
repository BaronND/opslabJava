package JavaIO.System;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author 禅师
 * @resume 向屏幕上输出信息
 */
public class demo1 {

    public static void main(String[] args) {

        //在System类中有常量out。是OutputStream的实例。代表向显示器上输出
        OutputStream out = System.out;

        String str = "hello world";
        try {
            out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

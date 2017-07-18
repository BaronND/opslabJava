package JavaIO.System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author 禅师
 * @resume 提示用户从键盘输入 x + y 等形式 输入 x + y = z的结果
 */
public class demo4 {

    public static void main(String[] args) {

        BufferedReader buf = null;
        buf = new BufferedReader(new InputStreamReader(System.in));

        //构造正则验证对象
        String pat = "\\d";
        Pattern patt = Pattern.compile(pat);

        String str = null;
        System.out.println("请输入：      x y");
        try {
            str = buf.readLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        //对数据的数据进行正则匹配
        Matcher matcher = patt.matcher(str);
        if (matcher.matches()) {
            String temp[] = str.split("+");
            int i = Integer.parseInt(new String(temp[0]));
            int j = Integer.parseInt(new String(temp[1]));

            System.out.println(i + "+" + j + "=" + (i + j));
        } else {
            System.out.println("输入的数据不合法");
        }

        try {
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

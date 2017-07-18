package JavaIO.System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 禅师
 * @resume 封装键盘输入
 * @function getString()                -获取键盘输入的字符串;
 * getInt(String errMsg)	-获取键盘输入的整数
 * getFloat(String errMsg) -获取键盘输入的浮点数
 * getDate(String errMsg)	-获取键盘输入的时间 格式为yyy-MM-dd
 */
public class InputKey {

    private String infoStr;                //提示信息
    private BufferedReader buf = null;    //输入缓冲区（字符流）

    public InputKey(String infoStr) {
        buf = new BufferedReader(new InputStreamReader(System.in));
        this.infoStr = infoStr;
    }

    public String getString() {
        String res = null;
        System.out.print(infoStr);

        try {
            res = buf.readLine();
        } catch (IOException e) {
            System.out.println("BufferedReader Exception:");
            e.printStackTrace();
        }
        return res;
    }

    public int getInt(String errMsg) throws IOException {
        int res = 0;
        System.out.print(infoStr);

        String temp = buf.readLine();
        if (temp.matches("^\\d+$")) {
            res = Integer.parseInt(temp);
        } else {
            System.out.println(errMsg);
        }
        return res;
    }

    public float getFloat(String errMsg) throws IOException {
        float res = 0.0f;
        System.out.print(infoStr);

        String temp = buf.readLine();
        if (temp.matches("^\\d+.?\\d+")) {
            res = Float.parseFloat(temp);
        } else {
            System.out.println(errMsg);
        }
        return res;
    }

    public Date getDate(String errMsg) throws IOException {
        Date date = null;
        System.out.print(infoStr);


        String str = buf.readLine();
        if (str.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");

            try {
                date = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(errMsg);
        }

        return date;
    }

    public void close() {
        try {
            buf.close();
        } catch (IOException e) {
            System.out.println("关闭键盘输入缓冲区异常");
            e.printStackTrace();
        }
    }


}

package JavaIO.MemoryStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author 禅师
 * @resume 向内存中写入数据
 */
public class Write {


    public static void main(String[] args) {

        String str = "hello world";

        ByteArrayInputStream bis = null;

        //向内存中写入数据
        bis = new ByteArrayInputStream(str.getBytes());


        try {
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

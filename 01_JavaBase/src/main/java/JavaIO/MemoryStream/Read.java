package JavaIO.MemoryStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author 禅师
 * @resume 直接在内存中转换字符串大小写
 */
public class Read {

    public static void main(String[] args) throws IOException {
        String str = "HELLO WORLD";

        ByteArrayInputStream bis = null;
        ByteArrayOutputStream bos = null;

        bis = new ByteArrayInputStream(str.getBytes());
        bos = new ByteArrayOutputStream();


        //从内存中读入数据
        int temp;
        while ((temp = bis.read()) != -1) {
            //强制将数字转换为字符
            char c = (char) temp;
            bos.write(Character.toLowerCase(c));
        }

        //获取转换后的字符串
        String res = bos.toString();

        bis.close();
        bos.close();

        System.out.println(res);
    }

}

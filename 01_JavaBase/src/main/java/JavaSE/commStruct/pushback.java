package JavaSE.commStruct;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

public class pushback {
    public static void main(String[] args) throws Exception {
        String str = "www.baidu.com";
        PushbackInputStream push = null;
        ByteArrayInputStream bai = null;
        bai = new ByteArrayInputStream(str.getBytes());
        push = new PushbackInputStream(bai);


        int temp = 0;
        while ((temp = push.read()) != -1) {
            if (temp == '.') {
                push.unread(temp);
                temp = push.read();

            } else {
                System.out.print((char) temp);
            }
        }
    }
}
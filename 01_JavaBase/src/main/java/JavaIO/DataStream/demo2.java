package JavaIO.DataStream;

import java.io.*;

/**
 * @author 禅师
 * @resume 读取DataOutputStream输出的数据
 */
public class demo2 {

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("C:\\test.txt");

        DataInputStream dis = new DataInputStream(new FileInputStream(f));

        String name = null;
        float prices = 0.0f;
        int nums = 0;

        char temp[] = null;
        int len = 0;
        char c;
        try {
            while (true) {
                temp = new char[100];
                while ((c = dis.readChar()) != '\t') {
                    temp[len] = c;
                    len++;
                }
                name = new String(temp, 0, len);
                prices = dis.readFloat();
                dis.readChar();
                nums = dis.readInt();
                System.out.print(name + "\t" + prices + "\t" + nums + dis.readChar());
            }
        } catch (IOException e) {

        }

        try {
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

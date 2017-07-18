package JavaIO.DataStream;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 禅师
 * @resume
 */
public class demo1 {

    public static void main(String[] args) throws IOException {
        File f = new File("C:\\test.txt");
        DataOutputStream bis = null;
        bis = new DataOutputStream(new FileOutputStream(f));

        String str[] = {"毛衣", "裤子", "鞋子"};
        float prices[] = {100.0f, 222, 2f, 150.0f};
        int nums[] = {3, 5, 3};

        for (int i = 0; i < 3; i++) {
            bis.writeChars(str[i]);
            bis.writeChar('\t');
            bis.writeFloat(prices[i]);
            bis.writeChar('\t');
            bis.writeInt(nums[i]);
            bis.writeChar('\n');
        }
        try {
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package JavaIO.File;

import java.io.File;

/**
 * @author 禅师
 * @resume 判断一个文件是否存在
 */
public class Exists {

    public static void main(String[] args) {
        String path = "c:\\test.txt";
        File file = new File(path);

        if (file.exists()) {
            System.out.println("文件：" + path + "\t存在");
        } else {
            System.out.println("文件: " + path + "\t不存在");
        }
    }
}

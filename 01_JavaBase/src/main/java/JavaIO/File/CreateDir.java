package JavaIO.File;

import java.io.File;

/**
 * @author 禅师
 * @resume 创建一个文件夹
 */
public class CreateDir {

    public static void main(String[] args) {
        String path = "c:\\test";
        File file = new File(path);

        if (file.mkdir()) {
            System.out.println("创建文件夹:" + path + "\t成功");
        } else {
            System.out.println("创建文件夹:" + path + "\t失败");
        }
    }

}

package JavaIO.File;

import java.io.File;

/**
 * @author 禅师
 * @resume 创建多级目录
 */
public class CreateDirs {

    public static void main(String[] args) {
        String path = "c:\\test\\test\\test";
        File file = new File(path);

        if (file.mkdirs()) {
            System.out.println("创建多级目录:" + path + "\t成功");
        } else {
            System.out.println("创建多级目录:" + path + "\t失败");
        }
    }

}

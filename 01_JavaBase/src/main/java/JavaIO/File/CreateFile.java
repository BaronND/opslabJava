package JavaIO.File;

import java.io.File;
import java.io.IOException;

/**
 * @author 禅师
 * @resume 创建一个新的文件
 */
public class CreateFile {

    public static void main(String[] args) {

        String path = "c:\\test.txt";

        File file = new File(path);

        //创建新文件
        try {
            file.createNewFile();
            System.out.println("创建文件： " + path + "\t成功");
        } catch (IOException e) {
            System.out.println("创建文件： " + path + "\t失败 \n产生异常：");
            e.printStackTrace();
        }
    }

}

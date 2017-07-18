package JavaIO.File;

import java.io.File;

/**
 * @author 禅师
 * @resume 删除指定文件
 */
public class DeleteFile {

    public static void main(String[] args) {

        String path = "c:\\test.txt";
        File file = new File(path);

        if (file.delete()) {
            System.out.println("删除文件： " + path + "\t成功");
        } else {
            System.out.println("删除文件: " + path + "\t失败");
        }
    }

}

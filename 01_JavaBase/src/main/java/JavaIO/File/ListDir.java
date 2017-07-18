package JavaIO.File;

import java.io.File;

/**
 * @author 禅师
 * @resume 遍历目录，列出所有的文件
 */
public class ListDir {

    public static void main(String[] args) {
        String path = "C:\\AppServ";
        File files = new File(path);
        List(files);

    }

    public static void List(File files) {
        File filess[] = files.listFiles();
        for (File file : filess) {
            if (file.isDirectory()) {
                List(file);
            } else {
                System.out.println(file);
            }
        }
    }
}

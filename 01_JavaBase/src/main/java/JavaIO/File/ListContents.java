package JavaIO.File;

import java.io.File;

/**
 * @author 禅师
 * @resume 列出给定目录中的内容
 */
public class ListContents {

    public static void main(String[] args) {

        String path = "C:\\AppServ";
        File files = new File(path);

        String contents[] = files.list();

        for (String file : contents) {
            System.out.println(file);
        }
    }

}

package JavaIO.File;

import java.io.File;
import java.io.FileFilter;


/**
 * @author 禅师
 * @resume 根据指定的规则列出符合规则的文件
 */
public class ListFileWithFilter {

    public static void main(String[] args) {
        //列出C盘下的所有exe文件
        String path = "C:\\AppServ";
        File file = new File(path);
        List(file);


    }

    public static void List(File files) {
        File filess[] = files.listFiles(new MyListFileFilter());
        for (File file : filess) {
            if (file.isDirectory()) {
                List(file);
            } else {
                System.out.println(file);
            }
        }
    }
}

class MyListFileFilter implements FileFilter {

    //如果是目录或.exe文件就返回真
    @Override
    public boolean accept(File pathname) {
        if (!(pathname.isDirectory())) {

            //System.out.println(pathname.getName());
            if (pathname.getName().endsWith(".exe")) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }


}

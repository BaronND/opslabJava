package JavaIO.File;

import java.io.File;

/**
 * @author 禅师
 * @resume 列出系统所有的盘符
 */
public class ListDriver {

    public static void main(String[] args) {
        File roots[] = File.listRoots();
        for (File root : roots) {
            System.out.println(root);
        }
    }

}

package JavaSE.FileMan;

import java.io.File;

public class ListFile {

    public static void main(String[] args) {
        File dir = new File("C:\\Users\\Administrator\\Desktop");
        File fs[] = dir.listFiles();
        for (File f : fs) {
            String remoteFile = f.getName();
            System.out.println(remoteFile);
        }
    }

}

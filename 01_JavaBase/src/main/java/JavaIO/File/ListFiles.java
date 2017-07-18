package JavaIO.File;
/***********************************************************************
 * Summary:
 * 		删除从JD-GUI反编译过来的Java代码的注释
 * @time 2013-12-26 17:05
 **********************************************************************/

import java.io.*;
import java.nio.channels.FileChannel;


public class ListFiles {

    public static String suffix = ".java";

    public static String separator = System.getProperty("line.separator");

    public static String path = "C:\\Users\\Administrator\\Desktop\\src";

    public static void main(String[] args) throws Exception {
        File files = new File(path);
        listFile(files);
    }

    public static void listFile(File file_obj) throws Exception {
        File files = file_obj;
        File filess[] = files.listFiles();
        for (File file : filess) {
            if (file.isDirectory()) {
                listFile(file);
            } else {
                HandleFile(file);
            }
        }
    }

    public static void HandleFile(File file) throws Exception {
        String file_name = file.getName();
        if (!file_name.endsWith(suffix)) {
            return;
        }
        Reader read_file = new InputStreamReader(new FileInputStream(file));
        BufferedReader sbuf = new BufferedReader(read_file);

        String line = "";
        StringBuffer buf = new StringBuffer();

        while ((line = sbuf.readLine()) != null) {
            int last_index = line.indexOf("*/");
            if (line.trim().startsWith("/*") && last_index > 0) {
                buf.append(line.substring(last_index + 2, line.length()) + separator);
            } else {
                buf.append(line + separator);
            }

        }
        read_file.close();
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        FileChannel fc = rf.getChannel();
        fc.truncate(0);
        rf.close();
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
        osw.write(buf.toString());
        osw.close();
    }

}


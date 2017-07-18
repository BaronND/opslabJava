package JavaIO.External;

import java.io.*;

/**
 * @author 禅师
 * @resume 有选择的进行对象序列化
 */
public class Seril {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File file = new File("c:\\Seri.txt");
        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(new FileOutputStream(file));

        Person per = null;
        per = new Person("禅师", 20);
        oos.writeObject(per);

        oos.close();
    }

}

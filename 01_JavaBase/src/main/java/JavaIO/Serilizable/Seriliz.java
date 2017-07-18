package JavaIO.Serilizable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author 禅师
 * @resume 对象序列化
 */
public class Seriliz {

    public static void main(String[] args) throws IOException, Exception {
        File file = new File("c:\\seri.txt");
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file));
        Person per = new Person("禅师", 20);

        //对象序列化
        oos.writeObject(per);

        oos.close();
    }

}

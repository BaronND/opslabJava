package JavaIO.External;

import java.io.*;

public class unSeril {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("c:\\seri.txt");
        ObjectInputStream ois = null;
        ois = new ObjectInputStream(new FileInputStream(file));

        Person per = null;
        per = (Person) ois.readObject();
        System.out.println(per);
        ois.close();

    }

}

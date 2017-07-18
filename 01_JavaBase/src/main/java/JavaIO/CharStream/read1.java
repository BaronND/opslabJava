package JavaIO.CharStream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class read1 {

    public static void main(String[] args) throws IOException {

        String path = "c:\\test.txt";
        File f = new File(path);
        Reader rdf = null;
        rdf = new FileReader(f);

        char temp[] = new char[1024];
        rdf.read(temp);
        System.out.println(new String(temp));
        rdf.close();
    }

}

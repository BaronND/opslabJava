package JavaSE.Enum;

import java.util.Enumeration;
import java.util.Vector;

public class EnumDemo {
    public static void main(String[] args) {
        Vector<String> all = new Vector<String>();
        all.add("hello");
        all.add("world");
        Enumeration<String> enums = all.elements();
        while (enums.hasMoreElements()) {
            System.out.print(enums.nextElement() + "~");
        }
    }
}
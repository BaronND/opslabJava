package JavaSE.collection;

import java.util.ArrayList;
import java.util.List;

public class foreachDemo {
    public static void main(String[] args) {
        List<String> all = new ArrayList<String>();
        all.add("hello");
        all.add("world");

        for (String temp : all) {
            System.out.print(temp + "~");
        }
    }
}
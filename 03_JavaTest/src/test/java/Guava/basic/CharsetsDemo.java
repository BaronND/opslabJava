package Guava.basic;

import com.google.common.base.Charsets;

/**
 * Charsets比较简单，提供了一些常量
 *
 * @author Enbandari
 */
public class CharsetsDemo {
    public static void main(String[] args) {
        String something = "something";
        byte[] bytes = something.getBytes(Charsets.UTF_8);
    }
}

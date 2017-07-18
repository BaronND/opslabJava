package JavaSE.StringDemo;

import java.nio.CharBuffer;

public class BufferDemo {
    public static void main(String[] args) {
        CharBuffer buff = CharBuffer.allocate(8);
        System.out.println("capacity:" + buff.capacity());
        System.out.println("limit:" + buff.limit());
        System.out.println("position:" + buff.position());

        //put data
        buff.put('a');
        buff.put('b');
        buff.put('c');
        System.out.println("put-position:" + buff.position());

        buff.flip();
        System.out.println("flip-capacity:" + buff.capacity());
        System.out.println("flip-limit:" + buff.limit());
        System.out.println("flip-position:" + buff.position());

        //get data
        System.out.println(buff.get());
        System.out.println("get-position:" + buff.position());
        System.out.println(buff.get());
        System.out.println("get-position:" + buff.position());
        System.out.println(buff.get());
        System.out.println("clear-capacity:" + buff.capacity());
        System.out.println("clear-limit:" + buff.limit());
        System.out.println("clear-position:" + buff.position());

        //get data by Absolute-index
        System.out.println(buff.get(2));
        System.out.println("get-date-by Absolute-index-capacity:" + buff.capacity());
        System.out.println("get-date-by Absolute-index-limit:" + buff.limit());
        System.out.println("get-date-by Absolute-index-position:" + buff.position());
    }
}
package JavaIO.System;

public class demo2 {

    public static void main(String[] args) {
        String str = "hello world";

        try {
            System.out.println(Integer.parseInt(str));
        } catch (Exception e) {
            System.err.println(e);
        }

    }

}

package JavaSE.random;

import java.util.Random;

public class Rondom {
    public static void main(String args[]) {
        Random r = new Random();
        for (int i = 0; i < 150; i++) {
            System.out.print(r.nextInt(100) + "\t");
            if (i != 0 && i % 10 == 0) {
                System.out.println();
            }
        }
    }
}
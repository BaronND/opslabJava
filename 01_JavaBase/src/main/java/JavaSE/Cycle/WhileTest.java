package JavaSE.Cycle;

import java.util.Random;

public class WhileTest {

    public static void main(String[] args) {
        boolean falg = false;
        int i = 0;
        while (!falg) {
            if (i > 4) {
                System.out.println("1111");
                break;
            }
            Random rand = new Random();
            int temp = rand.nextInt(2);
            System.out.println(temp);
            if (temp == 1) {
                falg = true;
            } else {
                i++;
                falg = false;

            }
        }
        System.out.println("while end!");
    }

}

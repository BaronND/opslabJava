package JavaSE.Enum;

import java.util.EnumSet;

public class EnumSetDemo {
    public static void main(String[] args) {
        EnumSet<Color> es = null;

        System.out.println("------EnumSet.allOf(Color.class)");
        es = EnumSet.allOf(Color.class);

        print(es);

    }

    public static void print(EnumSet<Color> temp) {
        for (Color c : temp) {
            System.out.print(c + "-");
        }
        System.out.println();
    }
}
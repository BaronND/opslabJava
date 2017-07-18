package JavaSE.Enum;

import java.util.EnumMap;
import java.util.Map;

enum Color {
    RED, GREEN, BLUE;
}

public class EnumMapDemo {
    public static void main(String[] args) {
        Map<Color, String> desc = null;

        desc = new EnumMap<Color, String>(Color.class);

        desc.put(Color.RED, "Red");
        desc.put(Color.GREEN, "Green");
        desc.put(Color.BLUE, "Blue");

        System.out.println("----all elements----");
        for (Color c : Color.values()) {
            System.out.print(c.name() + "--->" + desc.get(c));
        }
        System.out.println("----all key----");
        for (Color c : desc.keySet()) {
            System.out.print(c.name());
        }
        System.out.println("----all values----");
        for (String s : desc.values()) {
            System.out.print(s + "-");
        }

    }
}
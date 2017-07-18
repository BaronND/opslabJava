package JavaSE.collection.Enum;

enum colors {
    RED, GREEN, BULE;
}

public class PrintEnum {

    public static void main(String[] args) {
        for (colors temp : colors.values()) {
            System.out.print(temp + "\t");
        }
    }

}

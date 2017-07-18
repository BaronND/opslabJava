package JavaSE.Function;

public class Overload {
    public static void main(String[] args) {
        System.out.println(Info());

        System.out.println(Info(1));

        System.out.println(Info("^_^"));
    }

    public static String Info() {
        String info = "no params";
        return info;
    }

    public static String Info(int i) {
        String info = "a params,it's " + String.valueOf(i);
        return info;
    }

    public static String Info(String str) {
        String info = "a params,it's " + str;
        return info;
    }
}

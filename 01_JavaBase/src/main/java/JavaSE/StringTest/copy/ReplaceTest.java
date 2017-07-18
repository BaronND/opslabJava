package JavaSE.StringTest.copy;

public class ReplaceTest {

    public static void main(String[] args) {

        String[] ars = {"ab330ⅠV", "ab330ⅠabV", "ab330ⅡV", "ab330ⅢV"};

        for (int i = 0; i < ars.length; i++) {
            System.out.println(ars[i].replaceAll("\\D", ""));
            System.out.println(ars[i].replace("abV", "").replace("V", ""));
        }
    }

}

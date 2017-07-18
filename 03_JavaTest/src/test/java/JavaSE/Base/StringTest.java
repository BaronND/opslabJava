package JavaSE.Base;


public class StringTest {
    public static String[] str2Arr(String str, String tag) {
        if (str != null && str.length() > 0) {
            return str.split(tag);
        }
        return null;
    }
}

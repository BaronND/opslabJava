package JavaSE.Array;

/*******************************************
 *
 * @summary 演示使用foreach语句变量数组
 */
public class foreach {
    public static void main(String[] args) {
        String[] books = new String[]{
                "Python", "c/c++", "asm", "javascrip", "html/css",
                "Java", "PHP", "SQL"
        };

        for (String str : books) {
            System.out.println(str);
        }
    }
}

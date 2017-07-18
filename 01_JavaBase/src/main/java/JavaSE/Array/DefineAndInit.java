package JavaSE.Array;

/**************************************************
 * @summary 演示Java中数组的定义已经初始化
 *************************************************/
public class DefineAndInit {
    public static void main(String[] args) {

        System.out.println("演示Java的数组的定义以及初始化");

        // +-------------------------------------
        // | 定义一个字符串数组并采用静态初始化方式进行初始化
        //
        String[] book = new String[]{"hacking wtih python", "Java heading",
                "metasplit"};
        System.out.println(book + "\t该数组的长度" + book.length);
        for (int i = 0; i < book.length; i++) {
            System.out.print(book[i]);
        }

        //format print
        System.out.println();

        //
        // 动态初始化一个数组
        //
        String[] name = new String[5];
        System.out.println(name + "\t该数组的长度" + name.length);
        for (int i = 0; i < name.length; i++) {
            System.out.print(name[i]);
        }
    }
}

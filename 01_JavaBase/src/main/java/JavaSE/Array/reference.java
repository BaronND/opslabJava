package JavaSE.Array;

/*****************************************
 *
 * @Summary: 演示Java数组的引用
 ****************************************/
public class reference {


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 5, 4, 3};
        int[] b = a;

        printArray(a);
        printArray(b);


        b[2] = 100;
        printArray(a);
        printArray(b);
    }

    /*
     * print Array
     */
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}

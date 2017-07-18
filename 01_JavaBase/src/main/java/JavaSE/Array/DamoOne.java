package JavaSE.Array;

public class DamoOne {

    public static void main(String[] args) {

        int[] a = {0, 9, 4, 1, 7, 5, 3, 6, 2, 8};

        System.out.print("定义如下数组>");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }

        System.out.print("\n降序表示>");
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.print("\n升序表示>");
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}

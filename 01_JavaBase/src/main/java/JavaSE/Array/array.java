package JavaSE.Array;

import java.util.Arrays;

public class array {

    public static void main(String args[]) {
        int[] temp = {1, 3, 4, 2, 6, 8, 9, 7, 5};
        System.out.println("sort-before:" + Arrays.toString(temp));
        Arrays.sort(temp);
        System.out.println("sort-after:" + Arrays.toString(temp));
        int point = Arrays.binarySearch(temp, 3);
        System.out.println("the index of '3':" + point);
        Arrays.fill(temp, 3);
        System.out.println("fill with '3 '-after:" + Arrays.toString(temp));

    }
}
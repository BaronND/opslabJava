package JavaSE.Binary;

import java.util.Arrays;

public class ClassTest {


    public static void main(String[] args) {
        int[] temp = {1, 3, 4, 3, 6, 8, 9, 7, 5};
        int point = Arrays.binarySearch(temp, 3);
        System.out.println(point);
    }

}

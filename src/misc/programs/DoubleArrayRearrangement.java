package misc.programs;

import java.util.Arrays;

public class DoubleArrayRearrangement {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] res = new int[arr.length][arr.length];


        for (int i = 0; i < arr.length; i++) {
            int k = 0;
            for (int j = arr.length - 1; j >= 0; j--) {
                res[i][k++] = arr[j][i];
            }
        }

        System.out.print(Arrays.deepToString(res));
    }
}

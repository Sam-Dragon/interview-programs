package misc.programs.array;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class DoubleArrayRearrangement {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        DoubleArrayRearrangement obj = new DoubleArrayRearrangement();

        System.out.println("Java 8 Way");
        obj.java_8_way(arr);

        System.out.println("Java 7 Way");
        obj.java_7_way(arr);
    }

    private void java_8_way(int[][] arr) {
        int[][] res = new int[arr.length][arr.length];
        AtomicInteger k = new AtomicInteger();
        Stream.iterate(0, i -> i < arr.length, i -> i + 1)
                .peek(e -> k.getAndSet(0))
                .flatMap(i ->
                        Stream.
                                iterate(arr.length - 1, j -> j >= 0, j -> j - 1)
                                .map(j -> {
                                    res[i][k.getAndIncrement()] = arr[j][i];
                                    return res;
                                })
                )
                .limit((long) arr.length * arr.length)
                .count();

        System.out.println(Arrays.deepToString(res));
    }

    public void java_7_way(int[][] arr) {
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

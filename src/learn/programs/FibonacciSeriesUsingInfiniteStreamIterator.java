package learn.programs;

import java.util.Scanner;
import java.util.stream.IntStream;

public class FibonacciSeriesUsingInfiniteStreamIterator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of terms: ");
        int number = sc.nextInt();
        System.out.println("Number of terms: " + number);

        IntStream.iterate(0, i -> i + 1)
            .mapToObj(i -> {
                return new int[]{i, i};
            })
            .limit(number)
            .forEach(t -> System.out.println(t[0] + " " + t[1]));
    }
}

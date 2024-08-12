package learn.programs.odd_even.aggregation.count;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Stream.Range & Range closed method to pick range of numbers
 */
public class NumericStreamWay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the start number:");
        int first = sc.nextInt();
        System.out.println("Enter the end number:");
        int second = sc.nextInt();
        System.out.println("Given Range is from " + first + " & " + second);


        System.out.println("\nStream Range method");
        withRangeClosed(first, second);
    }

    private static void withRangeClosed(int first, int second) {
        long count = IntStream.rangeClosed(first, second)
            .filter(i -> i % 2 == 0)
            .count();
        System.out.println("Total Even Numbers = " + count);
    }
}

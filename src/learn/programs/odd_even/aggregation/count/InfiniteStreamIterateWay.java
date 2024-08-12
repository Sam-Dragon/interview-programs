package learn.programs.odd_even.aggregation.count;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Stream.iterate method to for limited range of numbers
 */
public class InfiniteStreamIterateWay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int number = sc.nextInt();

        System.out.println("\nInfinite Stream Iterate updated method");
        withIterate(number);
    }

    private static void withIterate(int number) {
        System.out.println("Even Numbers :: ");
        long count = Stream.iterate(0, i -> i < number, n -> n + 1)
            .filter(n -> n % 2 == 0)
            .count();
        System.out.println("Total Even Numbers = " + count);
    }
}

package learn.programs.odd_even;

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
        withRange(first, second);

        System.out.println("\nStream RangeClosed method");
        withRangeClosed(first, second);
    }

    private static void withRange(int first, int second) {
        System.out.println("Even Numbers :: ");
        IntStream.range(first, second)
            .filter(i -> i % 2 == 0)
            .forEach(i -> System.out.print(i + " "));
        System.out.println();

        System.out.println("Odd Numbers :: ");
        IntStream.range(first, second)
            .filter(i -> i % 2 != 0)
            .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    private static void withRangeClosed(int first, int second) {
        System.out.println("Even Numbers :: ");
        IntStream.rangeClosed(first, second)
            .filter(i -> i % 2 == 0)
            .forEach(i -> System.out.print(i + " "));
        System.out.println();

        System.out.println("Odd Numbers :: ");
        IntStream.rangeClosed(first, second)
            .filter(i -> i % 2 != 0)
            .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
}

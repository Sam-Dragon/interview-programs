package learn.programs.odd_even;

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
        Stream.iterate(0, i -> i < number, n -> n + 1)
            .filter(n -> n % 2 == 0)
            .forEach(e -> System.out.print(e + " "));
        System.out.println();

        System.out.println("Odd Numbers :: ");
        Stream.iterate(0, i -> i < number, n -> n + 1)
            .filter(n -> n % 2 != 0)
            .forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}

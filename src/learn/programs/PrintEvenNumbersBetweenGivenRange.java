package learn.programs;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Stream.Range method to pick range of numbers
 */
public class PrintEvenNumbersBetweenGivenRange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number:");
        int first = sc.nextInt();
        System.out.println("Enter the second number:");
        int second = sc.nextInt();
        System.out.println("Given Range is from " + first + " & " + second);

        IntStream.range(first, second)
            .filter(i -> i % 2 == 0)
            .forEach(i -> System.out.print(i + " "));
    }
}

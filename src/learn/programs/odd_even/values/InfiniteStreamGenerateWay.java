package learn.programs.odd_even.values;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Stream.Range & Range closed method to pick range of numbers
 */
public class InfiniteStreamGenerateWay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the start number:");
        int number = sc.nextInt();

        System.out.println("\nInfinite Stream Generate method");
        withGenerate(number);
    }

    private static void withGenerate(int number) {
        System.out.println("Even Numbers :: ");
        AtomicInteger even = new AtomicInteger(0);
        Stream.generate(() -> even.addAndGet(1))
            .filter(x -> x % 2 == 0)
            .limit(number)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("Odd Numbers :: ");
        AtomicInteger odd = new AtomicInteger(0);
        Stream.generate(() -> odd.addAndGet(1))
            .filter(x -> x % 2 != 0)
            .limit(number)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}

package learn.programs;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SquareOfNumbersUsingInfiniteStreams {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for square of: ");
        int num = sc.nextInt();

        IntStream.iterate(1, n -> n + 1)
            .peek(i -> System.out.print(i + " = "))
            .map(i -> i * i)
            .limit(num)
            .forEach(System.out::println);
    }
}

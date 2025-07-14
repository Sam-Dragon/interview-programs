package interview.programs.easy.java_8.natural_number;

import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SumOfNNaturalNumbers {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number for sum of 'N' Natural numbers");
        Integer input = sc.nextInt();

        // Solution - 1
        var sum = Optional.ofNullable(input)
                          .map(n -> n * (n + 1) / 2)
                          .get();
        System.out.println("Formula -> Sum = " + sum);

        // Solution - 2
        sum = Optional.ofNullable(input)
                      .map(n -> IntStream.rangeClosed(1, n)
                                         .sum())
                      .get();
        System.out.println("IntStream -> Sum = " + sum);
    }
}

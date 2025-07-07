package interview.programs.easy.java_8.natural_number;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SumOfNNaturalNumbers {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number for sum of 'N' Natural numbers");
        int input = sc.nextInt();

        if (input < 0) {
            System.out.println("Invalid Input");
        } else {
            var sum = IntStream.rangeClosed(1, input)
                    .sum();
            System.out.println("Sum = " + sum);
        }
    }
}

package interview.programs.easy.data_structure.recurrsion.fibonacci_series;

import java.util.Scanner;

public class SumOfFibonacciSeries {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number for printing 'N' Fibonacci series");
        int number = sc.nextInt();

        var sum = 0;

        for (int i = 0; i < number + 1; i++) {
            sum += fibonacci_series(i);
        }

        System.out.println("Sum (fib) of " + number + " = " + sum);
    }

    private static int fibonacci_series(int number) {
        if (number < 2) {
            return number;
        }

        int left = fibonacci_series(number - 1);
        int right = fibonacci_series(number - 2);

        return left + right;
    }
}

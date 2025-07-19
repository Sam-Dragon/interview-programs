package interview.programs.easy.data_structure.dynamic_programming.bottom_up_approach.fibonacci_series;

import java.util.Scanner;

public class SumOfFibonacciSeries {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number for sum of 'N' Fibonacci series");
        int number = sc.nextInt();

        if (number < 0) {
            System.out.println("Invalid Input");
            return;
        }

        var sum = fact(number);
        System.out.println("Sum (fib) of " + number + " = " + sum);
    }

    private static int fact(int number) {
        int[] arr = new int[number + 1];
        arr[0] = 0;
        arr[1] = 1;
        var sum = 0;

        if (number <= 2) {
            sum += arr[1];
        } else {
            sum = 1;
            for (int i = 2; i < number; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
                sum += arr[i];
            }
        }
        return sum;
    }
}

package interview.programs.easy.data_structure.dynamic_programming.top_down_approach.fibonacci_series;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfFibonacciSeries {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number for printing 'N' Fibonacci series");
        int number = sc.nextInt();

        int sum = 0;
        int[] arr = new int[number + 1];

        for (int i = 0; i < number + 1; i++) {
            sum += fibonacci_series(i, arr);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("Sum (fib) (" + number + ") = " + sum);
    }


    public static int fibonacci_series(int number, int[] arr) {
        if (arr[number] == 0) {
            // This is common logic which we are using in recursion
            if (number < 2) {
                arr[number] = number;
                return arr[number];
            }

            arr[number] = fibonacci_series(number - 1, arr) + fibonacci_series(number - 2, arr);
        }
        return arr[number];
    }
}

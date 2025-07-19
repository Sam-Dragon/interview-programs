package interview.programs.easy.data_structure.dynamic_programming.top_down_approach.fibonacci_series;

import java.util.Arrays;
import java.util.Scanner;

public class PrintFibonacciSeries {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number for printing 'N' Fibonacci series");
        int number = sc.nextInt();

        int[] arr = new int[number + 1];
        arr[0] = 0;
        arr[1] = 1;

        var result = fibonacci_series(number, arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("Fib (" + number + ") = " + result);
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

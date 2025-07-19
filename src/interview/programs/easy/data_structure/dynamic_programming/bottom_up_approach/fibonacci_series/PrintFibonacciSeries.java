package interview.programs.easy.data_structure.dynamic_programming.bottom_up_approach.fibonacci_series;

import java.util.Arrays;
import java.util.Scanner;

public class PrintFibonacciSeries {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number for printing 'N' Fibonacci series");
        int number = sc.nextInt();

        var result = fibonacci_series(number);
        System.out.println("Fib (" + number + ") = " + result);
    }

    private static int fibonacci_series(int number) {
        int[] arr = new int[number + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= number; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        System.out.print(Arrays.toString(arr));
        System.out.println();
        return arr[number];
    }
}

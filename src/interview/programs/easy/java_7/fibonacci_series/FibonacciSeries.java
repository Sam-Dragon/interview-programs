package interview.programs.easy.java_7.fibonacci_series;

import java.util.Scanner;

public class FibonacciSeries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to print fibonacci series");
        int number = sc.nextInt();

        fibonacciSeries(number);
    }

    public static void fibonacciSeries(int n) {
        int first = 0, second = 1;

        if (n == 0) {
            System.out.println(first);
        } else if (n == 1) {
            System.out.println(second);
        } else {
            System.out.print(first + " " + second);
            for (var i = 2; i < n; i++) {
                var sum = first + second;
                System.out.print(" " + sum);
                first = second;
                second = sum;
            }
            System.out.println();
        }
    }
}

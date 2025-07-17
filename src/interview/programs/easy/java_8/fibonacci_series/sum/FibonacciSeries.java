package interview.programs.easy.java_8.fibonacci_series.sum;

import java.util.Scanner;
import java.util.stream.Stream;

public class FibonacciSeries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to print fibonacci series");
        int number = sc.nextInt();

        fibonacciSeries(number);
    }

    public static void fibonacciSeries(int n) {
        var sum = Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                        .limit(n)
                        .mapToInt(arr -> arr[0])
                        .sum();

        System.out.println("Sum = " + sum);
    }
}

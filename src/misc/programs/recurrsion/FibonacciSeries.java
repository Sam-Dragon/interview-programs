package misc.programs.recurrsion;

import java.util.Scanner;

public class FibonacciSeries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :: ");

        int number = sc.nextInt();
        System.out.println("Print fibonacci series for " + number + " numbers");

        if (number <= 0) {
            System.out.println("Please enter valid number");
            return;
        }

        System.out.println(fib(number));
    }

    public static int fib(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}

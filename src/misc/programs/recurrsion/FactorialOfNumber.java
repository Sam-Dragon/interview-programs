package misc.programs.recurrsion;

import java.util.Scanner;

public class FactorialOfNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :: ");

        int number = sc.nextInt();
        System.out.println("Print factorial for " + number + " numbers");

        if (number < 0) {
            System.out.println("Please enter valid number");
            return;
        }

        int result = fact(number);
        System.out.println("Factorial of " + number + " is " + result);
    }

    private static int fact(int n) {
        if (n == 0 || n == 1)
            return 1;

        return n * fact(n - 1);
    }
}

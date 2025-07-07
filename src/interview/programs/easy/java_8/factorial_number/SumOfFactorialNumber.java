package interview.programs.easy.java_8.factorial_number;

import java.util.Scanner;

public class SumOfFactorialNumber {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number for sum of 'N' Factorial numbers");
        int input = sc.nextInt();

        if (input < 0) {
            System.out.println("Invalid Input");
        } else {
            var sum = 0;
            // TODO: LOGIC FOR SUM OF FACTORIALS
            System.out.println("Sum = " + sum);
        }
    }
}

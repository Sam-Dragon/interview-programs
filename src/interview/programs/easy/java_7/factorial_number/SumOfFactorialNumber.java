package interview.programs.easy.java_7.factorial_number;

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
            for (int i = 1; i <= input; i++) {
                var product = 1;
                for (int j = 1; j <= i; j++) {
                    product *= j;
                }
                sum += product;
            }
            System.out.println("Sum = " + sum);
        }
    }
}

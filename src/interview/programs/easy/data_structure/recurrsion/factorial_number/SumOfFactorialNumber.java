package interview.programs.easy.data_structure.recurrsion.factorial_number;

import java.util.Scanner;

public class SumOfFactorialNumber {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number for product of 'N' Natural numbers");
        int number = sc.nextInt();

        if (number < 0) {
            System.out.println("Invalid Input");
            return;
        }

        var sum = fact(number);
        System.out.println("Factorial of " + number + " = " + sum);
    }

    private static int fact(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }

        return number * fact(number - 1);
    }
}

package interview.programs.easy.data_structure.recurrsion.factorial_number;

import java.util.Scanner;

public class PrintFactorialNumber {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number for product of 'N' Natural numbers");
        int number = sc.nextInt();

        fact(number);
    }

    private static int fact(int number) {
        if (number == 1) {
            System.out.print(1 + " ");
            return 1;
        }

        int value = fact(number - 1);
        System.out.print(number + " ");
        return value;
    }
}

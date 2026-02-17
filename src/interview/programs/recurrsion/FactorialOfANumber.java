package interview.programs.recurrsion;

import java.util.Scanner;

public class FactorialOfANumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Number for factorial ?");
        int number = scanner.nextInt();
        System.out.print("Factorial of ( " + number + " ) = ");

        int factOfNumber = factOfNumber(number);
        System.out.println();
    }

    private static int factOfNumber(int number) {
        return 0;
    }
}

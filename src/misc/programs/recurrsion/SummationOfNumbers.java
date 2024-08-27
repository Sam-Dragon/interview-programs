package misc.programs.recurrsion;

import java.util.Scanner;

public class SummationOfNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :: ");

        int number = sc.nextInt();
        System.out.println("Print summation for " + number + " numbers");

        if (number <= 0) {
            System.out.println("Please enter valid number");
            return;
        }

        int result = summation(number);
        System.out.println("Summation of " + number + " is " + result);
    }

    private static int summation(int n) {
        if (n == 1)
            return 1;

        return n + summation(n - 1);
    }
}

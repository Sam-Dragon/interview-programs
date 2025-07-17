package interview.programs.easy.data_structure.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class PrintFactorialNumber {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number for product of 'N' Natural numbers");
        int number = sc.nextInt();

        if (number < 0) {
            System.out.println("Invalid Input");
            return;
        }

        int[] arr = new int[number + 1];
        var sum = fact(number, arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("Factorial of " + number + " = " + sum);
    }

    private static int fact(int number, int[] arr) {
        if (arr[number] == 0) {
            if (number == 0 || number == 1) {
                arr[number] = 1;
                return 1;
            }

            int value = number * fact(number - 1, arr);
            arr[number] = number;
            return value;
        }
        return arr[number];
    }
}

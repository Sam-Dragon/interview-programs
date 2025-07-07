package interview.programs.easy.java_7.natural_number;

import java.util.Scanner;

public class SumOfNNaturalNumbers {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number for sum of 'N' Natural numbers");
        int input = sc.nextInt();

        if (input < 0) {
            System.out.println("Invalid Input");
        } else {
            var sum = 0;
            for (int i = 1; i <= input; i++) {
                sum += i;
            }
            System.out.println("Sum = " + sum);
        }
    }
}

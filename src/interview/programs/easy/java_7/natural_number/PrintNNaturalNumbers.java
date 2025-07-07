package interview.programs.easy.java_7.natural_number;

import java.util.Scanner;

public class PrintNNaturalNumbers {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number for 'N' Natural numbers");
        int input = sc.nextInt();

        if (input < 0) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("Printing Numbers");
            for (int i = 1; i <= input; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

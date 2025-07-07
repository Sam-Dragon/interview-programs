package interview.programs.easy.java_7.natural_number;

import java.util.Scanner;

public class ProductOfNNaturalNumbers {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number for product of 'N' Natural numbers");
        int input = sc.nextInt();

        if (input < 0) {
            System.out.println("Invalid Input");
        } else {
            var product = 1;
            for (int i = 1; i <= input; i++) {
                product *= i;
            }
            System.out.println("Product = " + product);
        }
    }
}

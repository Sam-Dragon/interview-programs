package interview.programs.easy.java_8.natural_number;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProductOfNNaturalNumbers {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number for product of 'N' Natural numbers");
        int input = sc.nextInt();

        if (input < 0) {
            System.out.println("Invalid Input");
        } else {
            var product = IntStream.rangeClosed(1, input)
                    .reduce(1, (i1, i2) -> i1 * i2);
            System.out.println("Product = " + product);
        }
    }
}

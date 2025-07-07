package interview.programs.easy.java_8.natural_number;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PrintNNaturalNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number for 'N' Natural numbers");
        int input = sc.nextInt();

        if (input < 0) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("Printing Numbers");
            IntStream.rangeClosed(1, input)
                    .forEach(i -> System.out.print(i + " "));
        }
    }
}

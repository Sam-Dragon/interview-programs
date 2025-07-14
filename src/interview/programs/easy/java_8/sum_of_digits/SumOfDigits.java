package interview.programs.easy.java_8.sum_of_digits;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfDigits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to find its sum ? ");
        int number = sc.nextInt();

        System.out.println("Solution - 1");
        var sum = 0;
        int inputNumber = number;
        while (inputNumber > 0) {
            sum += inputNumber % 10;
            inputNumber = inputNumber / 10;
        }
        System.out.println("Sum of digits of number :: " + number + " = " + sum);

        System.out.println("Solution - 2");
        sum = Arrays.stream(String.valueOf(number)
                                  .split(""))
                    .mapToInt(Integer::valueOf)
                    .sum();
        System.out.println("Sum of digits of number :: " + number + " = " + sum);


        System.out.println("Solution - 3");
        sum = String.valueOf(number)
                    .chars()
                    .map(Character::getNumericValue)
                    .sum();
        System.out.println("Sum of digits of number :: " + number + " = " + sum);
    }
}

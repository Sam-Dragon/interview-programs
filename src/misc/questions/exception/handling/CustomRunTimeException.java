package misc.questions.exception.handling;

import java.util.Scanner;

public class CustomRunTimeException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int number = sc.nextInt();

        int output = new CustomRunTimeException().validate(number);
        System.out.println("Valid number: " + output);
    }

    public int validate(int number) {
        if (number <= 0)
            throw new InvalidRuntimeTimeException("Number cannot be zero or negative.");
        else
            return number;
    }
}


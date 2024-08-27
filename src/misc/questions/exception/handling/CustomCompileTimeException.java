package misc.questions.exception.handling;

import java.util.Scanner;

public class CustomCompileTimeException {

    public static void main(String[] args) throws InvalidCompileTimeException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int number = sc.nextInt();

        int output = new CustomCompileTimeException().validate(number);
        System.out.println("Valid number: " + output);

    }

    public int validate(int number) throws InvalidCompileTimeException {
        if (number <= 0)
            throw new InvalidCompileTimeException("Number cannot be zero or negative.");
        else
            return number;
    }
}


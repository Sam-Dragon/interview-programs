package misc.questions.exception.handling;

import java.util.Scanner;

public class NestedTryCatchRuntimeException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        String number = sc.nextLine();

        try {
            try {
                int num = Integer.parseInt(number);
                int result = 100 / num;
                System.out.println(result);
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic Exception");
            } catch (NumberFormatException e) {
                System.out.println("Number Format Exception");
            }
        } catch (Exception e) {
            System.out.println("Outer Exception :: " + e.getMessage());
        }
    }
}

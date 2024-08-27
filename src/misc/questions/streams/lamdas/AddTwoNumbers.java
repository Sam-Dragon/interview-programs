package misc.questions.streams.lamdas;

import java.util.Scanner;
import java.util.function.IntBinaryOperator;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.println("Enter second number: ");
        int num2 = sc.nextInt();

        IntBinaryOperator sumFI = Integer::sum;
        addUsingLamda(num1, num2, sumFI);
    }

    private static void addUsingLamda(int num1, int num11, IntBinaryOperator sumFI) {
        System.out.println("Result :: " + sumFI.applyAsInt(num1, num11));
    }
}

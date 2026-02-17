package interview.programs.java_7.strings.reverse.string;

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The Input");
        String string = scanner.nextLine();
        System.out.println("Entered Input :: " + string);

        ReverseString object = new ReverseString();

        System.out.println("\nReverse using split()");
        object.reverseUsingSplit(string);

        System.out.println("\nReverse using toCharArray()");
        object.reverseUsingCharArray(string);

        System.out.println("\nReverse using StringBuilder()");
        object.reverseUsingStringBuilder(string);

        System.out.println("\nReverse using StringBuffer()");
        object.reverseUsingStringBuffer(string);
    }

    private void reverseUsingStringBuffer(String string) {
        String reversed = new StringBuffer(string).reverse()
                                                  .toString();
        System.out.println(reversed);
    }

    private void reverseUsingStringBuilder(String string) {
        String reversed = new StringBuilder(string).reverse()
                                                   .toString();
        System.out.println(reversed);
    }

    private void reverseUsingCharArray(String string) {
        // char Array + StringBuilder + For loop
        char[] charArr = string.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (int i = charArr.length - 1; i >= 0; i--) {
            builder.append(charArr[i]);
        }

        System.out.println(builder);
    }

    private void reverseUsingSplit(String string) {
        // string Array + StringBuilder + For loop
        String[] stringArray = string.split("");
        StringBuilder builder = new StringBuilder();
        for (int i = stringArray.length - 1; i >= 0; i--) {
            builder.append(stringArray[i]);
        }

        System.out.println(builder);
    }
}

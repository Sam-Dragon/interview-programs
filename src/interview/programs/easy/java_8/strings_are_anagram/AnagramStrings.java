package interview.programs.easy.java_8.strings_are_anagram;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnagramStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The First String");
        String firstString = sc.nextLine();

        System.out.println("Enter The Second String");
        String secondString = sc.nextLine();

        System.out.println("Entered String are First String = " + firstString + ", Second String = " + secondString);

        if (firstString.length() != secondString.length()) {
            System.out.println("Anagram Strings ? " + Boolean.valueOf("false"));
            return;
        }

        // Solution - 1
        System.out.println("Solution - 1");
        var firstFinalString = Arrays.stream(firstString.split(""))
                                     .sorted()
                                     .collect(Collectors.joining());

        var secondFinalString = Arrays.stream(secondString.split(""))
                                      .sorted()
                                      .collect(Collectors.joining());

        System.out.println("firstFinalString = " + firstFinalString + ", secondFinalString = " + secondFinalString);
        System.out.println("Anagram Strings ? " + firstFinalString.equalsIgnoreCase(secondFinalString));
    }
}

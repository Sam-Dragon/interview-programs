package interview.programs.easy.java_8.reverse_string_words;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseEachWordOfString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please provide string to reverse each word ? ");
        String input = sc.nextLine();

        // Solution - 1
        var reversedString = Stream.of(input.split(" "))
                                   .map(str -> new StringBuilder(str).reverse())
                                   .collect(Collectors.joining(" "));
        System.out.println("\nEntered String = " + input + "\nReversed String = " + reversedString);
    }
}

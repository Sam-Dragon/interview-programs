package misc.programs;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordOccurrenceInString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string: ");

        String input = sc.nextLine();
        System.out.println("entered string: " + input);

        countWordsInSentenceUsingGroupBy(input);
    }

    private static void countWordsInSentenceUsingGroupBy(String input) {
        Arrays.stream(input.split("\\s"))
            .map(String::toLowerCase)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .forEach((k, v) -> System.out.println(k + ": " + v));
    }
}

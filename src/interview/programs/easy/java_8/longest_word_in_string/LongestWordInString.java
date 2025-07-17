package interview.programs.easy.java_8.longest_word_in_string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestWordInString {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String whose longest word you want to find ?");
        String input = sc.nextLine();
        System.out.println("input :: " + input);

        System.out.println();
        System.out.println("Solution 1");
        Arrays.stream(input.split(" "))
              .max(Comparator.comparing(String::length))
              .stream()
              .findFirst()
              .ifPresent(System.out::println);

        System.out.println();
        System.out.println("Solution 2");
        Arrays.stream(input.split(" "))
              .collect(Collectors.toMap(Function.identity(), String::length))
              .entrySet()
              .stream()
              .max(Map.Entry.comparingByValue())
              .map(Map.Entry::getKey)
              .ifPresent(System.out::println);
    }
}

package interview.programs.easy.java_8.palindrome_map;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PalindromeMap {

    public static void main(String[] args) {

        List<String> list = List.of("level", "apple", "radar", "banana", "madam");

        System.out.println("Solution 1");
        list.stream()
            .collect(Collectors.toMap(Function.identity(), s -> new StringBuilder(s).reverse()
                                                                                    .toString()
                                                                                    .equals(s)))
            .forEach((k, v) -> System.out.println(k + " = " + v));


        System.out.println();
        System.out.println("Solution 2");
        list.stream()
            .collect(Collectors.toMap(Function.identity(), s -> s.contentEquals(new StringBuilder(s).reverse())))
            .forEach((k, v) -> System.out.println(k + " = " + v));

    }
}

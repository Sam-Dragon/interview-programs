package interview.programs.easy.java_8.min_frequency_char_in_str;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumFrequencyOfCharacterInString {

    public static void main(String[] args) {

        var input = "banana appllee";

        System.out.println("Solution 1");
        var map = Arrays.stream(input.split(""))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        var value = map.entrySet()
                       .stream()
                       .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                       .filter(m -> !String.valueOf(m)
                                           .isEmpty())
                       .map(Map.Entry::getKey)
                       .limit(1)
                       .collect(Collectors.joining());
        System.out.println(value);

        System.out.println();
        System.out.println("Solution 2");
        var char_map = input.chars()
                            .mapToObj(c -> (char) c)
                            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        char_map.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .ifPresent(System.out::println);
    }
}

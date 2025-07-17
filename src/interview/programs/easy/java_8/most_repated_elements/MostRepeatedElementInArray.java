package interview.programs.easy.java_8.most_repated_elements;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostRepeatedElementInArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2, 3, 2, 4, 5, 3, 3, 6, 2, 3};

        Map<Integer, Long> map = Arrays.stream(arr)
                                       .boxed()
                                       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        System.out.println();
        System.out.println("Solution - 1");
        map.entrySet()
           .stream()
           .max(Map.Entry.comparingByValue())
           .map(Map.Entry::getKey)
           .ifPresent(System.out::println);

        System.out.println();
        System.out.println("Solution - 2");
        map.entrySet()
           .stream()
           .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
           .limit(1)
           .map(Map.Entry::getKey)
           .forEach(System.out::println);
    }
}

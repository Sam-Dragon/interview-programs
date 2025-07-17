package interview.programs.easy.java_8.distinct_number_in_sorted_order;

import java.util.List;

public class DistinctNumberInSortedOrder {

    public static void main(String[] args) {

        List<Integer> list = List.of(123, 12, 11, 451, 31, 34, 541, 23, 21, 16, 21, 11);

        System.out.println("Solution 1");
        list.stream()
            .filter(i -> i % 10 == 1)
            .distinct()
            .sorted()
            .forEach(System.out::println);

        System.out.println();
        System.out.println("Solution 2");
        list.stream()
            .distinct()
            .filter(i -> String.valueOf(i)
                               .endsWith("1"))
            .sorted()
            .forEach(System.out::println);

    }
}

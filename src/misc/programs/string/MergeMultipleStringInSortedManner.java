package misc.programs.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeMultipleStringInSortedManner {

    public static void main(String[] args) {
        String[] array = {"yx", "qp", "ba"};

        Stream.of(array)
                .map(MergeMultipleStringInSortedManner::SortingString)
                .toList()
                .forEach(System.out::println);
    }

    private static String SortingString(String string) {
        List.of(string.toCharArray())
                .stream().sorted()
                .collect(Collectors.toSet());

        return "";
    }
}

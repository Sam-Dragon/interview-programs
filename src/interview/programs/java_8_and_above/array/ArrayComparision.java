package interview.programs.java_8_and_above.array;

import java.util.Arrays;

public class ArrayComparision {

    public static void main(String[] args) {
        String[] first_array = {"one", "two"};
        String[] second_array = {"two", "one"};

        var allMatched = false;
        if (first_array.length == second_array.length) {
            allMatched = Arrays.stream(first_array)
                               .allMatch(e -> Arrays.stream(second_array)
                                                    .anyMatch(e::equalsIgnoreCase));
        }

        System.out.println(allMatched);
    }
}

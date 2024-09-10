package misc.programs;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllCharactersUniquePerString {

    public static String checkIfUnique(String input) {
        int uniqueCharLength = Stream.of(input.split(""))
            .collect(Collectors.toSet())
            .size();

        return input + " : " + (uniqueCharLength == input.length());
    }

    public static void main(String[] args) {
        String[] array = {"hi", "hello", "good", "morning"};

        Arrays.stream(array)
            .map(AllCharactersUniquePerString::checkIfUnique)
            .forEach(System.out::println);
    }
}

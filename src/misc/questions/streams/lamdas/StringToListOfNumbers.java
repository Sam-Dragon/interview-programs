package misc.questions.streams.lamdas;

import java.util.Arrays;
import java.util.List;

public class StringToListOfNumbers {

    public static void main(String[] args) {

        List<String> numbers = List.of("1,2,3,4,5,6", "7,8,9,10");
        numbers.stream()
            .map(String::trim)
            .flatMap(s -> Arrays.stream(s.split(",")))
            .forEach(System.out::println);
    }
}

package misc.questions.streams.lamdas;

import java.util.Comparator;
import java.util.stream.Stream;

public class SortStringAndLimitOutput {

    public static void main(String[] args) {

        Stream.of("ram", "Tam", "sam", "cam", "Sam", "Nam")
            .sorted(Comparator.comparing(String::toString)
                .reversed())
            .limit(3)
            .forEach(System.out::println);
    }
}

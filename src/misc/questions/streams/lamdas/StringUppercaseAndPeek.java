package misc.questions.streams.lamdas;

import java.util.stream.Stream;

public class StringUppercaseAndPeek {

    public static void main(String[] args) {
        Stream.of("rama", "Tamim", "Samuel")
            .peek(s -> System.out.println("string :: " + s + " & length :: " + s.length()))
            .map(String::toUpperCase)
            .forEach(System.out::println);
    }
}

package misc.questions.streams.lamdas;

import java.util.stream.IntStream;

public class StreamToFilterRecords {

    public static void main(String[] args) {
        IntStream.iterate(1, i -> i + 1)
            .limit(10)
//            .peek(i -> System.out.println("Input :: " + i))
            .filter(i -> i < 5)
            .forEach(i -> System.out.println("Output :: " + i));
    }
}

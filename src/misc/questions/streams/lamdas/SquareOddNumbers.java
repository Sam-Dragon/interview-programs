package misc.questions.streams.lamdas;

import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class SquareOddNumbers {

    public static void main(String[] args) {
        IntPredicate evenFunction = n -> n % 2 == 0;
        IntUnaryOperator squareFunc = n -> n * n;

        IntStream.rangeClosed(1, 6)
            .filter(evenFunction)
            .map(squareFunc)
            .forEach(System.out::println);
    }
}

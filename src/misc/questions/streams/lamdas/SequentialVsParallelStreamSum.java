package misc.questions.streams.lamdas;

import java.util.Random;
import java.util.stream.IntStream;

public class SequentialVsParallelStreamSum {

    public static void main(String[] args) {
        Random random = new Random();

        var startTime = System.currentTimeMillis();
        int sequentialSum = IntStream.rangeClosed(1, 100)
            .sequential()
            .sum();
        System.out.println(sequentialSum + " took " + (System.currentTimeMillis() - startTime) + " ms");

        startTime = System.currentTimeMillis();
        int parallelSum = IntStream.rangeClosed(1, 100)
            .parallel()
            .sum();
        System.out.println(parallelSum + " took " + (System.currentTimeMillis() - startTime) + " ms");

    }
}

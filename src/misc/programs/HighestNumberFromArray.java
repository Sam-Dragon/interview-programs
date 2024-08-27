package misc.programs;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class HighestNumberFromArray {

    public static void main(String[] args) {
        int[] array = {12, 34, 43, 6, 66, 3, 23, 21};

        highestNumberFromArrayUsingSummaryStatistics(array);
        highestNumberFromArrayUsingReduce(array);
    }

    private static void highestNumberFromArrayUsingReduce(int[] array) {
        int max = IntStream.of(array)
            .reduce(0, Integer::max);

        System.out.println("Highest number: " + max);
    }

    private static void highestNumberFromArrayUsingSummaryStatistics(int[] array) {
        IntSummaryStatistics result = IntStream.of(array)
            .summaryStatistics();
        int max = result.getMax();

        System.out.println("Highest number: " + result.getMax());
    }
}

package learn.programs.odd_even.aggregation.summarization;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamSummarizingWay {

    public static void main(String[] args) {
        System.out.println("Enter the numbers: ");
        var sc = new Scanner(System.in);
        var numbers = sc.nextLine();

        // String of numbers to Integer list
        var numberList = Arrays.stream(numbers.split(","))
            .map(Integer::parseInt)
            .toList();
        System.out.println("Input numbers: " + numberList);

        IntSummaryStatistics statistics = countNumbers(numberList);
        System.out.println("Total Even Numbers = " + statistics.getCount());
        System.out.println("Sum Even Numbers = " + statistics.getSum());
        System.out.println("Max Even Numbers = " + statistics.getMax());
        System.out.println("Min Even Numbers = " + statistics.getMin());
        System.out.println("Avg Even Numbers = " + statistics.getAverage());
    }

    private static IntSummaryStatistics countNumbers(List<Integer> numbers) {
        return numbers.stream()
            .filter(i -> i % 2 == 0)
            .collect(Collectors.summarizingInt(Integer::intValue));
    }
}

package learn.programs.odd_even.aggregation.count;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StreamMapReduceWay {

    public static void main(String[] args) {
        System.out.println("Enter the numbers: ");
        var sc = new Scanner(System.in);
        var numbers = sc.nextLine();

        // String of numbers to Integer list
        var numberList = Arrays.stream(numbers.split(","))
            .map(Integer::parseInt)
            .toList();
        System.out.println("Input numbers: " + numberList);

        System.out.println("Total Even Numbers = " + countNumbers(numberList));
    }

    private static long countNumbers(List<Integer> numbers) {
        return numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(i -> 1)
            .reduce(0, Integer::sum);
    }
}

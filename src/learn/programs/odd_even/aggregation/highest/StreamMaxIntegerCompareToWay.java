package learn.programs.odd_even.aggregation.highest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StreamMaxIntegerCompareToWay {

    public static void main(String[] args) {
        System.out.println("Enter the numbers: ");
        var sc = new Scanner(System.in);
        var numbers = sc.nextLine();

        // String of numbers to Integer list
        var numberList = Arrays.stream(numbers.split(","))
            .map(Integer::parseInt)
            .toList();
        System.out.println("Input numbers: " + numberList);

        System.out.println("Max Even Number = " + maxOfNumbers(numberList));
    }

    private static long maxOfNumbers(List<Integer> numbers) {
        return numbers.stream()
            .filter(n -> n % 2 == 0)
            .sorted()
            .max(Integer::compareTo)
            .orElse(0);
    }
}

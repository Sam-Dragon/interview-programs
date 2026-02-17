package interview.programs.java_8_and_above.numbers.odd_even.aggregation.highest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamMaxWay {

    public static void main(String[] args) {
        System.out.println("Enter the numbers: ");
        var sc = new Scanner(System.in);
        var numbers = sc.nextLine();

        // String of numbers to Integer list
        var numberList = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("Input numbers: " + numberList);

        System.out.println("Max Even Number = " + maxOfNumbers(numberList));
    }

    private static long maxOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0);
    }
}

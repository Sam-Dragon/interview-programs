package learn.programs.odd_even;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamCollectGroupingBy {

    public static void main(String[] args) {
        System.out.println("Enter the numbers: ");
        var sc = new Scanner(System.in);
        var numbers = sc.nextLine();

        // String of numbers to Integer list
        var numberList = Arrays.stream(numbers.split(","))
            .map(Integer::parseInt)
            .toList();
        System.out.println("Input numbers: " + numberList);

        printOddEvenNumbers(numberList);
    }

    private static void printOddEvenNumbers(List<Integer> numbers) {
        var numberList = numbers.stream()
            .collect(Collectors.groupingBy(x -> x % 2 == 0));

        var evenNumbers = numberList.get(true);
        System.out.println("Even numbers: " + evenNumbers);

        var oddNumbers = numberList.get(false);
        System.out.println("Odd numbers: " + oddNumbers);

    }
}

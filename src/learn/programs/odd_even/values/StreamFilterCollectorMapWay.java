package learn.programs.odd_even.values;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StreamFilterCollectorMapWay {

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
        var evenNumbers = numbers.stream()
            .filter(x -> x % 2 == 0)
            .collect(ArrayList::new, List::add, List::addAll);
        System.out.println("Even numbers: " + evenNumbers);

        var oddNumbers = numbers.stream()
            .filter(x -> x % 2 != 0)
            .collect(ArrayList::new, List::add, List::addAll);
        System.out.println("Odd numbers: " + oddNumbers);

    }
}

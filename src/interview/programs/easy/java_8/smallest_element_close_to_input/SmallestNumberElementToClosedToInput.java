package interview.programs.easy.java_8.smallest_element_close_to_input;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SmallestNumberElementToClosedToInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input number :: ");
        int number = sc.nextInt();
        System.out.println("Enter the input to get closest number :: " + number);

        var list = List.of(-10, 2, 4, 8, 15, 1);
        System.out.println("Input array :: " + list);


        System.out.println("Solution 1");
        var result = list.stream()
                         .filter(i -> i < number)
                         .collect(Collectors.toMap(Function.identity(), i -> Math.abs(number - i)))
                         .entrySet()
                         .stream()
                         .min(Map.Entry.comparingByValue())
                         .map(Map.Entry::getKey)
                         .stream()
                         .findFirst()
                         .orElse(-1);

        System.out.println("Closest Number to Input :: " + number + " is = " + (result));

        System.out.println("Solution 2");
        result = list.stream()
                     .filter(i -> i < number)
                     .min(Comparator.comparingInt(i -> Math.abs(number - i)))
                     .orElse(-1);

        System.out.println("Closest Number to Input :: " + number + " is = " + (result));
    }
}

package interview.programs.easy.java_8.closest_number_to_input;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClosestElementToGivenInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input number :: ");
        int number = sc.nextInt();
        System.out.println("Enter the input to get closest number :: " + number);

        var list = List.of(-10, 2, 4, 8, 15, 1);
        System.out.println("Input array :: " + list);

        System.out.println("Solution 1");
        var closestIndex = list.stream()
                               .collect(Collectors.toMap(Function.identity(), i -> Math.abs(number - i)))
                               .entrySet()
                               .stream()
                               .min(Map.Entry.comparingByValue())
                               .map(Map.Entry::getKey)
                               .map(list::indexOf)
                               .stream()
                               .findFirst()
                               .orElse(-1);

        System.out.println("Closest Number to Input :: " + number + " is at index = " + (closestIndex));

        System.out.println();
        System.out.println("Solution 2");

        closestIndex = list.stream()
                           .min(Comparator.comparing(i -> Math.abs(number - i)))
                           .stream()
                           .findFirst()
                           .map(list::indexOf)
                           .get();

        System.out.println("Closest Number to Input :: " + number + " is at index = " + (closestIndex));

        System.out.println();
        System.out.println("Solution 3");

        closestIndex = IntStream.range(0, list.size())
                                .boxed()
                                .min(Comparator.comparingInt(i -> Math.abs(list.get(i) - number)))
                                .orElse(-1);

        System.out.println("Closest Number to Input :: " + number + " is at index = " + (closestIndex));
    }
}

package misc.programs.string.sort.characters;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortStringCharacters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Input");

        String s = sc.nextLine();
        System.out.println("Entered Input :: " + s);

        System.out.println("\nCharacters sorted using sorted");
        sortTheCharacters(s);

        System.out.println("\nCharacters sorted using grouping");
        sortTheCharactersGrouping(s);

        System.out.println("\nCharacters sorted using reduce");
        sortTheCharactersReduce(s);
    }

    private static void sortTheCharactersReduce(String input) {
        System.out.print("Sorted Characters :: ");
        String result = input.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .map(String::toLowerCase)
                .sorted(Collections.reverseOrder())
                .reduce((a, b) -> a + b).orElse("");
        System.out.println(result);
    }

    private static void sortTheCharacters(String input) {
        System.out.print("Sorted Characters :: ");
        Arrays.stream(input.toLowerCase()
                        .split(""))
                .sorted(Comparator.comparing(String::toString)
                        .reversed())
                .forEach(System.out::print);
        System.out.println();
    }

    private static void sortTheCharactersGrouping(String input) {
        System.out.print("Sorted Characters :: ");
        Stream.of(input.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity()))
                .values()
                .stream()
                .flatMap(Collection::stream)
                .sorted(Collections.reverseOrder())
                .forEach(System.out::print);
        System.out.println();
    }
}

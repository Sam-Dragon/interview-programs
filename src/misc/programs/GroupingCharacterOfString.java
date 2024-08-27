package misc.programs;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingCharacterOfString {

    public static void main(String[] args) {
        System.out.println("Enter the input :: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println("Entered input :: " + input);
        groupTheCharacters(input);
    }

    private static void groupTheCharacters(String input) {
        Arrays.stream(input.split(""))
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.toList()))
            .values()
            .stream()
            .flatMap(Collection::stream)
            .forEach(System.out::print);
    }
}

package misc.programs.string.group.string;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingStringOfString {

    public static void main(String[] args) {
        System.out.println("Enter the sentence :: ");
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        System.out.println("Entered sentence :: " + sentence);

        GroupingStringOfString obj = new GroupingStringOfString();
        obj.groupString(sentence);
    }

    private void groupString(String sentence) {
        Stream.of(sentence.split("\\s"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.toList()))
                .values()
                .stream()
                .flatMap(Collection::stream)
                .forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}

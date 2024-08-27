package misc.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortStringCharacters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Input");

        String s = sc.nextLine();
        System.out.println("Entered Input :: " + s);

        sortTheCharacters(s);
    }

    private static void sortTheCharacters(String input) {
        Arrays.stream(input.toLowerCase()
                .split(""))
            .sorted(Comparator.comparing(String::toString)
                .reversed())
            .forEach(System.out::println);
    }
}

package misc.programs.string.reverse.words;

import java.util.Scanner;
import java.util.stream.Stream;

public class ReverseWordsUsingLoop {

    public static void main(String[] args) {
        System.out.println("Enter a sentence: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Entered sentence :: " + input);

        ReverseWordsUsingLoop obj = new ReverseWordsUsingLoop();
        obj.reverseWordsFromInput(input);
    }

    private void reverseWordsFromInput(String input) {
        String[] words = input.split(" ");

        System.out.print("Reversed sentence :: ");
        Stream.iterate(words.length - 1, i -> i >= 0, i -> i - 1)
            .map(index -> words[index])
            .limit(words.length)
            .forEach(word -> System.out.print(word + " "));
        System.out.println();
    }
}

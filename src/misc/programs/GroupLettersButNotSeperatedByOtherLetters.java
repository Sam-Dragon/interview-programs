package misc.programs;

import java.util.Arrays;
import java.util.Scanner;

public class GroupLettersButNotSeperatedByOtherLetters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string :: ");

        String input = sc.nextLine();
        System.out.println("Entered input :: " + input);

        System.out.println(input + " " + preventSequencedLetterSeperatedByOthers(input));
        ;
    }

    private static boolean preventSequencedLetterSeperatedByOthers(String input) {
        Arrays.stream(input.split(""))
            .distinct()
            .filter(i -> input.lastIndexOf(i) - input.indexOf(i) <= 1);
//            .map()

        return false;
    }
}

package misc.programs.string.convert;

import java.util.Arrays;
import java.util.List;

public class StringToCharacterArray {

    public static void main(String[] args) {
        String input = new String("Sample");

        System.out.println("Using toCharArray");
        char[] toCharArray = input.toCharArray();
        List.of(toCharArray).forEach(System.out::print);
        System.out.println();

        System.out.println("Using getChars");
        char[] getCharsArr = new char[input.length()];
        input.getChars(0, input.length(), getCharsArr, 0);
        List.of(getCharsArr).forEach(System.out::print);
        System.out.println();
    }
}

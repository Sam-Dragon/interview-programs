package interview.programs.strings.characters;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindInitialsOfString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the Name ?");
        String name = sc.nextLine();

        var initials = Arrays.stream(name.split(" "))
                             .map(s -> s.charAt(0))
                             .map(String::valueOf)
                             .collect(Collectors.joining());

        System.out.println("Employee Initials :: " + initials);
    }
}

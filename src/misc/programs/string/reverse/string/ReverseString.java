package misc.programs.string.reverse.string;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println("Enter the String");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Entered string :: " + input);

        ReverseString obj = new ReverseString();
        System.out.println("\nReverse using iterate");
        obj.reverseStringUsingIterate(input);

        System.out.println("\nReverse using stack");
        obj.reverseStringUsingStack(input);

        System.out.println("\nReverse using reduce");
        obj.reverseStringUsingReduce(input);

        System.out.println("\nReverse using builder");
        obj.reverseStringUsingStringBuilder(input);

        System.out.println("\nReverse using buffer");
        obj.reverseStringUsingStringBuffer(input);
    }

    private void reverseStringUsingIterate(String input) {
        char[] array = input.toCharArray();
        Stream.iterate(input.length() - 1, i -> i >= 0, i -> i - 1)
                .map(i -> array[i])
                .toList()
                .forEach(System.out::print);
        System.out.println();
    }

    private void reverseStringUsingStack(String input) {
        Stack<String> stack = new Stack<>();
        List<String> characters = Stream.of(input.split(""))
                .map(stack::push)
                .toList();

        String reversed = characters.stream().map(e -> stack.pop()).collect(Collectors.joining());
        System.out.println(reversed);
    }

    private void reverseStringUsingReduce(String input) {
        String reversed = input.chars().mapToObj(ch -> String.valueOf((char) ch)).reduce((a, b) -> b + a).orElse("");
        System.out.println(reversed);
    }

    private void reverseStringUsingStringBuilder(String input) {
        String reversed = Stream.of(input)
                .map(e -> new StringBuilder(e).reverse())
                .collect(Collectors.joining());
        System.out.println(reversed);
    }

    private void reverseStringUsingStringBuffer(String input) {
        String reversed = Stream.of(input)
                .map(e -> new StringBuffer(e).reverse())
//                .peek(System.out::println)
                .collect(Collectors.joining());
        System.out.println(reversed);
    }


}

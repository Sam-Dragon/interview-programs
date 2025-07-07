package interview.programs.strings.reverse.words;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverseWordsUsingStack {

    Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        System.out.println("Enter a sentence: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Entered sentence :: " + input);

        ReverseWordsUsingStack obj = new ReverseWordsUsingStack();
        obj.reverseWordsFromInput(input);
    }

    private void reverseWordsFromInput(String input) {
        Arrays.stream(input.split(" "))
                .forEach(stack::push);

        System.out.print("Reversed sentence :: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}

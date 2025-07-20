package interview.programs.easy.java_7.smallest_element_close_to_input;

import java.util.List;
import java.util.Scanner;

public class SmallestNumberElementToClosedToInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input number :: ");
        int number = sc.nextInt();
        System.out.println("Enter the input to get closest number :: " + number);

        var list = List.of(-10, 2, 4, 8, 15, 1);
        System.out.println("Input array :: " + list);

        int previous = number;
        for (int i = 0; i < list.size(); i++) {
            var element = list.get(i);
            var diff = number - element;

            if (Math.abs(diff) < Math.abs(previous) && Math.abs(element) < Math.abs(number))
                previous = diff;
        }

        System.out.println("prev" + previous);
        System.out.println("Closest Number to Input :: " + number + " is = " + (number - previous));
    }
}

package interview.programs.easy.java_7.closest_number_to_input;

import java.util.List;
import java.util.Scanner;

public class ClosestElementToGivenInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input number :: ");
        int number = sc.nextInt();
        System.out.println("Enter the input to get closest number :: " + number);

        var list = List.of(-10, 2, 4, 8, 15, 1);
        System.out.println("Input array :: " + list);

        if (list.contains(number)) {
            System.out.println("Closest Number to Input :: " + number + " is at index = " + (list.indexOf(number)));
        } else {
            int previous = number;
            for (int i = 0; i < list.size(); i++) {
                var element = list.get(i);
                var diff = number - element;

                if (Math.abs(diff) < Math.abs(previous))
                    previous = diff;
            }

            System.out.println("prev" + previous);
            System.out.println("Closest Number to Input :: " + number + " is at index = " + (list.indexOf(number - previous)));
        }
    }
}

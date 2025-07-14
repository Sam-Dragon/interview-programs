package interview.programs.easy.java_8.print_multiples;

import java.util.List;
import java.util.Scanner;

public class MultipleOfInputNumber {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 25, 30, 42, 50, 7, 15);
        System.out.println("Predefined List :: " + numbers);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want to find multiple of ? ");
        int number = sc.nextInt();

        numbers.stream()
               .filter(i -> number > 0 && i % number == 0)
               .forEach(i -> System.out.print(i + " "));
    }
}

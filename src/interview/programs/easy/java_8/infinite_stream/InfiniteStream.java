package interview.programs.easy.java_8.infinite_stream;

import java.util.Scanner;
import java.util.stream.Stream;

public class InfiniteStream {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of values you want print ?");
        int number = sc.nextInt();

        System.out.println("Print Numbers From 1 to 10");
        Stream.iterate(1, i -> i + 1)
              .limit(number)
              .forEach(System.out::println);
    }
}

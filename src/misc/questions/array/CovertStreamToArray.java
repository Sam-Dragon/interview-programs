package misc.questions.array;

import java.util.List;
import java.util.stream.Stream;

public class CovertStreamToArray {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 4, 5, 6, 7, 8, 9);
        System.out.println("List Numbers");
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("Array Numbers");
        int[] numArr = numbers.stream().mapToInt(Integer::valueOf).toArray();
        Stream.iterate(0, i -> i < numArr.length, i -> i + 1)
                .map(i -> numArr[i])
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}

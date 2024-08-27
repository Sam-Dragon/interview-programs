package misc.questions;

import java.util.stream.IntStream;

public class LeastValueInArray {

    public static void main(String[] args) {
        int[] arr = {30, 33, 40, 24, 45, 21, 56};

        var least = IntStream.of(arr)
            .reduce(Integer::min);
        System.out.println("Least: " + least.getAsInt());
    }
}

package misc.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AddUniqueElementsToArrayList {

    public static void main(String[] args) {
        String[] arr = new String[5];
        arr[0] = "A";
        arr[1] = "B";
        arr[2] = "C";
        arr[3] = "B";
        arr[4] = "A";

        List<String> list = new ArrayList<>();
        Stream.of(arr)
            .filter(s -> {
                var result = false;
                if (!list.contains(s)) result = list.add(s);
                return result;
            })
            .forEach(System.out::println);

    }
}

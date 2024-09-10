package misc.programs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MultiplyArrayElements {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] != arr[j]) {
                    List<Integer> inner = new LinkedList<>();
                    inner.add(arr[i]);
                    inner.add(arr[j]);
                    map.put(arr[i], inner);
                }
            }
        }

        System.out.println(map);
    }
}

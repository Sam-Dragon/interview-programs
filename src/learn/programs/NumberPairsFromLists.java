package learn.programs;

import java.util.List;

public class NumberPairsFromLists {

    public static void main(String[] args) {
        List<Integer> aList = List.of(1, 2, 3);
        List<Integer> bList = List.of(3, 4);

        NumberPairsFromLists obj = new NumberPairsFromLists();
        obj.getPairs(aList, bList);
    }

    public void getPairs(List<Integer> aList, List<Integer> bList) {
        aList.stream()
                .flatMap(a -> bList.stream().map(b -> new Integer[]{a, b}))
                .forEach(t -> System.out.printf("[" + t[0] + "," + t[1] + "]"));
    }
}

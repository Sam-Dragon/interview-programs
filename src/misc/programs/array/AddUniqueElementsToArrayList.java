package misc.programs.array;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AddUniqueElementsToArrayList {

    public static void main(String[] args) {
        String[] arr = new String[]{"A", "B", "C", "B", "A"};

        AddUniqueElementsToArrayList obj = new AddUniqueElementsToArrayList();
        System.out.println("refactor using distinct way");
        obj.refactorUsingDistinctWay(arr);

        System.out.println("\nrefactor using set way");
        obj.refactorUsingSetWay(arr);

        System.out.println("\nrefactor using grouping way");
        obj.refactorUsingGroupingWay(arr);

        System.out.println("\nrefactor using collect way");
        obj.refactorUsingCollectWay(arr);

        System.out.println("\nrefactor using Range way");
        obj.refactorUsingIntStreamRangeWay(arr);

        System.out.println("\nrefactor using iterator way");
        obj.refactorUsingStreamIteratorWay(arr);
    }

    private void refactorUsingStreamIteratorWay(String[] arr) {
        Stream.iterate(0, i -> i < arr.length, i -> i + 1)
                .map(i -> arr[i])
                .distinct()
                .forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private void refactorUsingIntStreamRangeWay(String[] arr) {
        IntStream.range(0, arr.length)
                .mapToObj(i -> arr[i])
                .distinct()
                .forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private void refactorUsingCollectWay(String[] arr) {
        TreeSet<String> treeSet = Stream.of(arr)
                .collect(Collectors.toCollection(TreeSet::new));

        treeSet.forEach(a -> System.out.print(a + " "));
        System.out.println();
    }


    public void refactorUsingGroupingWay(String[] arr) {
        Stream.of(arr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .keySet()
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

    public void refactorUsingSetWay(String[] arr) {
        Set<String> set = Stream.of(arr)
                .collect(Collectors.toSet());

        set.forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

    public void refactorUsingDistinctWay(String[] arr) {
        List<String> list = Stream.of(arr)
                .distinct()
                .toList();

        list.forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}

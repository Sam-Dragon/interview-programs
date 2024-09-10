package misc.programs.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeTwoListsInSortedManner {

    public static void main(String[] args) {
        System.out.println("Enter the numbers for first list [comma separated]");
        Scanner sc = new Scanner(System.in);
        String arrayInStringForA = sc.nextLine();
        System.out.println("Enter Array String for first list :: " + arrayInStringForA);

        System.out.println("Enter the numbers for second list [comma separated]");
        String arrayInStringForB = sc.nextLine();
        System.out.println("Enter Array String for second list :: " + arrayInStringForB);

        List<Integer> aList = Stream.of(arrayInStringForA.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("First list :: " + aList);

        List<Integer> bList = Stream.of(arrayInStringForB.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Second list :: " + bList);

        MergeTwoListsInSortedManner obj = new MergeTwoListsInSortedManner();
        System.out.println("Merge using sorted method");
        obj.sortListUsingSorted(aList, bList);
    }

    private void sortListUsingSorted(List<Integer> aList, List<Integer> bList) {
        System.out.println("Sorted List");
        aList.addAll(bList);

        aList.stream().sorted()
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
    }
}

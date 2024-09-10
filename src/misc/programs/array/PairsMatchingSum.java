package misc.programs.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PairsMatchingSum {

    public static void main(String[] args) {
        System.out.println("Enter the numbers [comma separated]");
        Scanner sc = new Scanner(System.in);
        String arrayInString = sc.nextLine();
        System.out.println("Enter Array String :: " + arrayInString);

        System.out.println("Enter the sum");
        int sum = sc.nextInt();
        System.out.println("Entered sum :: " + sum);

        PairsMatchingSum obj = new PairsMatchingSum();
        obj.pairsMatchingSum(arrayInString, sum);
    }

    private void pairsMatchingSum(String arrayInString, int sum) {
        List<Integer> numbers = Stream.of(arrayInString.split(","))
                .map(Integer::parseInt)
                .toList();

        // list processed for matching sum
        numbers.stream()
                .flatMap(a -> numbers.stream()
                        .map(b -> new Pair(a, b)))
                .filter(p -> (p.getA() + p.getB()) == sum)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }
}

class Pair {
    private int a;
    private int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return (a == pair.a && b == pair.b) || (a == pair.b && b == pair.a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(new HashSet<>(Arrays.asList(a, b)));
    }

    @Override
    public String toString() {
        return "[" + a + "," + b + "]";
    }
}
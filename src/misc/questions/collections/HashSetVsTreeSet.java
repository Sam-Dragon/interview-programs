package misc.questions.collections;

import java.util.HashSet;
import java.util.TreeSet;

public class HashSetVsTreeSet {

    public static void main(String[] args) {
        HashSet<String> hashset = new HashSet<>();
        hashset.add("a");
        hashset.add(null);
        System.out.println(hashset);

        TreeSet<String> treeset = new TreeSet<>();
        treeset.add("a");
        treeset.add(null);
        System.out.println(treeset);
    }
}

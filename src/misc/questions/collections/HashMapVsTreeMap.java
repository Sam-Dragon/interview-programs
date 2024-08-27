package misc.questions.collections;

import java.util.HashMap;
import java.util.TreeMap;

public class HashMapVsTreeMap {

    public static void main(String[] args) {
        HashMap<String, String> hashmap = new HashMap<>();
        hashmap.put("a", "a");
        hashmap.put(null, null);
        System.out.println(hashmap);

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("a", "a");
        treeMap.put(null, null);
        System.out.println(treeMap);
    }
}

package interview.programs.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class InputMapFindValueBasedKeys {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("John", 28);
        map.put("jessie", 31);
        map.put("michal", 31);
        map.put("james", 28);
        map.put("william", 29);

        var result = map.entrySet()
                        .stream()
                        .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println(result);
    }
}

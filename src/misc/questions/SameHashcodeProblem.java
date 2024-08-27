package misc.questions;

import java.util.HashMap;
import java.util.Map;

public class SameHashcodeProblem {

    public static void main(String[] args) {
        Map<AA, String> map = new HashMap<>();
        map.put(new AA("A"), "A");
        map.put(new AA("B"), "B");
        System.out.println(map.get(new AA("A")));
    }
}

class AA {
    public String name = null;

    public AA(String name) {
        this.name = name;
    }

    public int hashCode() {
        return 3;
    }
}
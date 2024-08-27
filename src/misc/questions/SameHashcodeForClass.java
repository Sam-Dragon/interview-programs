package misc.questions;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SameHashcodeForClass {

    public static void main(String[] args) {
        SameHashcodeClass instance1 = new SameHashcodeClass();
        instance1.setName("instance1");
        System.out.println("Hashcode - 1" + instance1.hashCode());

        SameHashcodeClass instance2 = new SameHashcodeClass();
        instance2.setName("instance2");
        System.out.println("Hashcode - 2" + instance2.hashCode());

        System.out.println(instance1.hashCode() == instance2.hashCode());
        System.out.println(instance1.equals(instance2));

        Set<SameHashcodeClass> set = new HashSet<>();
        set.add(instance1);
        set.add(instance2);
        set.forEach(System.out::println);
    }
}

class SameHashcodeClass {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SameHashcodeClass that = (SameHashcodeClass) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "SameHashcodeClass{" +
            "name='" + this.name + '\'' +
            '}';
    }
}

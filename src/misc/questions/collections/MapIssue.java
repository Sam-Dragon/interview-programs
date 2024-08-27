package misc.questions.collections;

import java.util.HashMap;
import java.util.Map;

public class MapIssue {

    public static void main(String[] args) {
        Map<EmployeeId, Employee> map = new HashMap<>();
        EmployeeId emp_id = new EmployeeId(1);
        map.put(emp_id, new Employee("A"));
        map.put(new EmployeeId(2), new Employee("B"));
        map.get(emp_id);
        map.get(new EmployeeId(2));

        System.out.println(map);
    }
}

class EmployeeId {
    int id;

    public EmployeeId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class Employee {
    String name = null;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
package interview.programs.java_8_and_above.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageSalaryBasedGrouping {

    public static void main(String[] args) {

        Map<String, Integer> employeeSalaryMap = new HashMap<>();

        employeeSalaryMap.put("John", 75000);
        employeeSalaryMap.put("jessie", 50000);
        employeeSalaryMap.put("michal", 55000);
        employeeSalaryMap.put("james", 80000);
        employeeSalaryMap.put("william", 62000);

        double averageSalary = employeeSalaryMap.entrySet()
                                                .stream()
                                                .mapToInt(Map.Entry::getValue)
                                                .summaryStatistics()
                                                .getAverage();


        var result = employeeSalaryMap.entrySet()
                                      .stream()
                                      .collect(Collectors.groupingBy(e -> e.getValue() > averageSalary ? "Above Average" : "Below Average"));

        System.out.println(result);

        System.out.println("Using Partitioning By");

        var partitionResult = employeeSalaryMap.entrySet()
                                               .stream()
                                               .collect(Collectors.partitioningBy(e -> e.getValue() > averageSalary));
        System.out.println(partitionResult);

    }
}

package com.problemsolving.exercise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Trial {
    public static void main(String[] args) {
        List<Employee> emps= new ArrayList<>();

        emps.add(new Employee("1", "Ahmed"));
        emps.add(new Employee("2", "Moihammed"));

        Map<String, Employee> map = emps.stream()
                .collect(Collectors.toMap(emp -> emp.getId(), emp-> emp));

        System.out.println(map);
    }
}

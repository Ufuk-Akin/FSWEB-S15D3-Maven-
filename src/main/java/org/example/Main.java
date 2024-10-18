package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {

    private static Map<Integer, Employee> mapEmployees;
    private static List<Employee> duplictatedList;


    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1,"ufuk","akın"));
        employees.add(new Employee(1,"ufuk","yılma"));
        employees.add(new Employee(1,"ufuk","keskin"));
        employees.add(new Employee(2,"ahmet","ber"));
        employees.add(new Employee(2,"ahmet","ber"));
        employees.add(new Employee(3,"A","a"));
        employees.add(new Employee(4,"B","b"));
        employees.add(new Employee(5,"C","c"));

        System.out.println(findDuplicates(employees));
        System.out.println(findUniques(employees));
        System.out.println(removeDuplicates(employees));



    }

    public static List <Employee> findDuplicates(List <Employee> employees) {
        mapEmployees = new HashMap<>();
        duplictatedList = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if(employee == null){
                System.out.println(" null record");
                continue;
            }
            if (mapEmployees.containsKey(employee.getId())) {
                duplictatedList.add(employee);
            } else {
                mapEmployees.put(employee.getId(), employee);
            }
        }
        return duplictatedList;
    }

    public static Map<Integer, Employee> findUniques(List <Employee> employees) {
        mapEmployees = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null){
                System.out.println(" null record");
                continue;
            }
            if (!mapEmployees.containsKey(employee.getId())) {
                mapEmployees.put(employee.getId(), employee);
            }
        }
        return mapEmployees;
    }

    public static List <Employee> removeDuplicates(List <Employee> employees) {

        List<Employee> dup = findDuplicates(employees);
        Map<Integer,Employee> uniques = findUniques(employees);
        List<Employee> uniquesList = new LinkedList<>(uniques.values());

        uniquesList.removeAll(dup);
        return uniquesList;
    }

}
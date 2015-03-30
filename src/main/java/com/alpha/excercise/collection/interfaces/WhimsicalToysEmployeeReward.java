package com.alpha.excercise.collection.interfaces;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by anantagarwal on 27/03/2015.
 */
public class WhimsicalToysEmployeeReward {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee[]{new Employee("tom", "A"),
                new Employee("jon", "b"), new Employee("jon", "c")}));
        Random random = new Random();

        System.out.println(employees.get(random.nextInt(employees.size())));

        List<String> firstNames = employees.stream().map(Employee::getFirstName).collect(Collectors.toList());
        Set<String> uniqueFirstNames = new HashSet<>(firstNames);
        System.out.println(uniqueFirstNames);

        Map<String, Integer> popularNamesMap = new HashMap<>();
        for (String firstName : firstNames) {
            Integer freq = popularNamesMap.get(firstName);
            popularNamesMap.put(firstName, freq == null ? 1 : freq + 1);
        }
        System.out.println(popularNamesMap);

        Queue<Employee> ticketQueue = new LinkedList<>(employees);
        System.out.println(ticketQueue.poll());


    }

    public static class Employee{
        private final String firstName;
        private final String lastName;

        public Employee(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
}

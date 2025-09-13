package com.problemsolving.w3global;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();   //Name, age

        people.add(new Person("John", 34));
        people.add(new Person("Joe", 45));
        people.add(new Person("Reed", 19));
        people.add(new Person("Patrick", 25));
        people.add(new Person("Parker", 27));
        people.add(new Person("Lisa", 39));
        people.add(new Person("Drake", 31));
        people.add(new Person("Tom", 28));
        people.add(new Person("Jim", 22));

        //Logic: Find the number of people above 25 years
        if (people == null) {
            System.out.println("Number of people above 25 years is 0.");
        } else {
            long count = countPeopleAboveGivenAge(people, 25);
            System.out.println("Number of people above 25 years is " + count + ".");
        }
    }

    //The following implementation uses the for loop.
    private static long countPeopleAboveGivenAge(List<Person> people, int age) {
        return people.stream()
                .filter(person -> person.getAge() > age)
                .count();
    }
    public static class Person {

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}

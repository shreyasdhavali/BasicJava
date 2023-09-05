package com.sand.java.Collections;

import java.util.*;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

}

public class HashSetWithCustomEqualityExample {
    public static void main(String[] args) {
        Set<Person> personSet = new HashSet<>();
        personSet.add(new Person("Alice", 25));
        personSet.add(new Person("Bob", 30));
        personSet.add(null);
        personSet.add(new Person("Alice", 25));


        Person alice = new Person("Alice", 25);
        boolean containsAlice = personSet.contains(alice);
        System.out.println("Contains Alice: " + containsAlice); // Should print true
        System.out.println(personSet);
//        for objects always use hashset no not use treeSet;
//        Set<Person> tree = new TreeSet<>(Comparator.comparing(Person::getName));
//        personSet.add(new Person("Alice", 25));
//        personSet.add(new Person("Bob", 30));
//        personSet.add(new Person("Alice", 25));
//        System.out.println(tree);
    }
}


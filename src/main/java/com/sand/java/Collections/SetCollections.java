package com.sand.java.Collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class SetCollections {

    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student("a", 1));
        set.add(new Student("b", 9));
        set.add(new Student("r", 1));
        set.add(new Student("q", 4));
        set.add(new Student("h", 6));
        set.add(new Student("h", 8));
        set.add(new Student("h", 8));
        set.add(new Student("y", 8));
        set.add(new Student("e", 3));
        set.add(new Student("a", 0));
        set.add(new Student("a", 0));
        set.add(new Student("m", 1));
        System.out.println(set);
        set.stream().sorted(Comparator.comparing(Student::getId)
                .thenComparing(Student::getName)).forEach(System.out::println);
    }
}

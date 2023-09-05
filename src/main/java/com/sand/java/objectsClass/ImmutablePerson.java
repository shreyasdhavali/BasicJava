package com.sand.java.objectsClass;

public final class ImmutablePerson {
    private final String name;
    private final int age;
    private int salary;

    public ImmutablePerson(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}


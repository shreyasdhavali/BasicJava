package com.sand.java.solid;

public class ISegregationP {
}

// Violation: Employee class implements unnecessary method

// Fix: Separate interfaces to match client needs
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Employee implements Workable, Eatable {
    @Override
    public void work() {
        // Perform work
    }

    @Override
    public void eat() {
        // Eat during break
    }
}

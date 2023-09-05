package com.sand.java.designPatterns.structural.proxy;

public class ActualService implements Service {
    @Override
    public void operation() {
        System.out.println("Actual service invoking");
    }
}

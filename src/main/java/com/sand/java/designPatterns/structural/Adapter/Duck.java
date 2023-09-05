package com.sand.java.designPatterns.structural.Adapter;

public class Duck implements Bird {
    @Override
    public void makeSound() {
        System.out.println("Duck is making the sound");
    }
}

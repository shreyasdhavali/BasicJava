package com.sand.java.designPatterns.structural.Adapter;

public class Main {

    public static void main(String[] args) {
        Bird bird = new Duck(); // client is using
        bird.makeSound();

        Bird toy = new AdapterPattern(new PlasticHenToy());
        toy.makeSound();

    }
}

package com.sand.java.designPatterns.structural.Adapter;

public class AdapterPattern implements Bird {

    PlasticBird bird;

    public AdapterPattern(PlasticBird bird) {
        this.bird = bird;
    }

    @Override
    public void makeSound() {
        this.bird.squeak();
    }
}

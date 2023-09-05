package com.sand.java.designPatterns.structural.Adapter;

public class PlasticHenToy implements PlasticBird {
    @Override
    public void squeak() {
        System.out.println("Squeaking");
    }
}

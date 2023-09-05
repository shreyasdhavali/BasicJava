package com.sand.java.designPatterns.structural.composite;

public class Gift implements SurpriseBox {
    private String name;

    public Gift(String name) {
        this.name = name;
    }
    @Override
    public void unwrap() {
        System.out.println("Unwrapping gift " + this.name);
    }
}

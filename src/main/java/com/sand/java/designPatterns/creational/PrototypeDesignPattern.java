package com.sand.java.designPatterns.creational;

class PrototypeDesignPattern implements Cloneable {
    private String data;

    public PrototypeDesignPattern(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public PrototypeDesignPattern clone() {
        try {
            return (PrototypeDesignPattern) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

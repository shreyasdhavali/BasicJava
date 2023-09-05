package com.sand.java.designPatterns.structural.flyweight;

class TreeType {
    private String name;
    private String color;

    public TreeType(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing " + name + " tree of color " + color + " at (" + x + ", " + y + ")");
    }
}
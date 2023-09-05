package com.sand.java.designPatterns.structural.facade;

public class Facade {
    public static void main(String[] args) {
        ShapeMaker maker = new ShapeMaker();
        maker.drawCircle();
        maker.drawRectangle();
    }
}

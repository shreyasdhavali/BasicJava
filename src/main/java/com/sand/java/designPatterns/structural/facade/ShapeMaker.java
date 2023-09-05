package com.sand.java.designPatterns.structural.facade;

public class ShapeMaker {

    Shape circle = new Circle();
    Shape rectangle = new Rectangle();

    public void drawCircle() {
        this.circle.draw();
    }

    public void drawRectangle() {
        this.rectangle.draw();
    }
}

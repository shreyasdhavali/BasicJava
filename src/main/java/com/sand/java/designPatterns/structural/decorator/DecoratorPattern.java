package com.sand.java.designPatterns.structural.decorator;

public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee.cost();
        coffee.description();
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.cost() + " " + coffee.description());
    }
}

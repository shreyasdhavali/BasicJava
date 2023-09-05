package com.sand.java.designPatterns.structural.decorator;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public double cost() {
        return decoratedCoffee.cost() + 1;
    }

    public String description() {
        return decoratedCoffee.description() + " with Milk";
    }}

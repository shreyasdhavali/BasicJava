package com.sand.java.designPatterns.behavioral.template;

class DinnerMeal extends AbstractMeal {
    protected void prepareIngredients() {
        System.out.println("Gathering ingredients for dinner");
    }

    protected void cook() {
        System.out.println("Cooking dinner");
    }

    protected void eat() {
        System.out.println("Eating dinner");
    }

    protected void cleanUp() {
        System.out.println("Cleaning up after dinner");
    }
}

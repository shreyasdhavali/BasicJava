package com.sand.java.designPatterns.behavioral.template;

class BreakfastMeal extends AbstractMeal {
    protected void prepareIngredients() {
        System.out.println("Gathering ingredients for breakfast");
    }

    protected void cook() {
        System.out.println("Cooking breakfast");
    }

    protected void eat() {
        System.out.println("Eating breakfast");
    }

    protected void cleanUp() {
        System.out.println("Cleaning up after breakfast");
    }
}


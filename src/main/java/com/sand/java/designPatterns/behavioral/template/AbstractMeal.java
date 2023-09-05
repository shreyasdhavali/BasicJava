package com.sand.java.designPatterns.behavioral.template;

abstract class AbstractMeal {
    // Template method that defines the algorithm structure
    public final void prepareMeal() {
        prepareIngredients();
        cook();
        eat();
        cleanUp();
    }

    // Abstract methods to be overridden by subclasses
    protected abstract void prepareIngredients();
    protected abstract void cook();
    protected abstract void eat();
    protected abstract void cleanUp();
}


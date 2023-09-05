package com.sand.java.designPatterns.behavioral.template;

public class TemplateMethodPattern {
    public static void main(String[] args) {
        AbstractMeal breakfast = new BreakfastMeal();
        AbstractMeal dinner = new DinnerMeal();

        System.out.println("Preparing breakfast:");
        breakfast.prepareMeal();

        System.out.println("\nPreparing dinner:");
        dinner.prepareMeal();
    }
}


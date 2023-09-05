package com.sand.java.Collections;

import java.util.Comparator;

public class Product {
    private String name;
    private int weight;
    private int age;
    private float price;

    public Product() {
    }

    public Product(String name, int weight, float price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public static Comparator<Product> compareByWeight() {
        return Comparator.comparingInt(Product::getWeight);
    }

    public static Comparator<Product> compareByName() {
        return Comparator.comparing(Product::getName);
    }

    public static Comparator<Product> compareByPrice() {
        return Comparator.comparingDouble(Product::getPrice);
    }

    @Override
    public String toString() {
        return "Product : name - " + this.getName() + ", weight - " + this.getWeight()
                + ", price - " + this.getPrice();
    }
}

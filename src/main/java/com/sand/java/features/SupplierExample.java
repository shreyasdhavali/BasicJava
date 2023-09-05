package com.sand.java.features;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        Supplier<Integer> randomIntSupplier = () -> new Random().nextInt(100);

        int randomValue = randomIntSupplier.get();
        System.out.println("Random Value: " + randomValue);
    }
}


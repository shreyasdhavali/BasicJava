package com.sand.java.features;

import java.util.function.Function;

public class FunctionApply {

    public static void main(String[] args) {
        Function<Integer, String> intToString = number -> "Number: " + number;

        System.out.println(intToString.apply(42)); // Prints "Number: 42"
    }
}


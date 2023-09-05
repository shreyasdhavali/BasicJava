package com.sand.java.features;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.function.*;

public class Java8Features implements MyInterface, Serializable {

    public static void main(String[] args) throws ScriptException {
        // Lambda expressions
        Runnable runnableLambda = () -> System.out.println("Hello, Lambda!");


        // FunctionalInterface && method reference
        Calculator add = Integer::sum;
        Calculator sub = (a, b) -> a - b;
        Calculator mul = (a, b) -> a * b;
        System.out.println(add.calculate(5, 3) + " " + sub.calculate(5, 3) + " " + mul.calculate(5, 3));

        // Streams
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Using map to transform each element to its square
        List<Integer> squares = numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());

        System.out.println("Original Numbers: " + numbers);
        System.out.println("Squared Numbers: " + squares);

        // Using reduce to find the sum of all squared numbers
//        int sumOfSquares = squares.stream()
//                .reduce(0, (total, square) -> total + square);
        int sumOfSquares = squares.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum of Squares: " + sumOfSquares);

        // Default and static methods in interface
        MyInterface.staticMethod();
        Java8Features features = new Java8Features();
        features.defaultMethod();

        // Optional class
        Optional<String> name = Optional.ofNullable(null);
        System.out.println(name.orElse("Default Name")); // Prints "Default Name"

        // New Date and time
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        //Default Methods for Comparator
        List<String> names = Arrays.asList("Charlie", "Bob", "Alice");
        names.sort(Comparator.comparing(String::toString).reversed());
        System.out.println(names);

        //Nashorn JS Engine
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("print('Hello, Nashorn');");

        // New java.util.function
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(4)); // Prints "true"


        //Method references
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using an instance method reference to find the sum of even numbers
        int sum = numbers1.stream()
                .filter(Java8Features::isEven)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of even numbers: " + sum);

        //Constructor Method Reference:
        Function<String, Person> personFactory = Person::new;

        Person person1 = personFactory.apply("Alice");
        Person person2 = personFactory.apply("Bob");

        System.out.println(person1.getName()); // Prints "Alice"
        System.out.println(person2.getName()); // Prints "Bob"
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }


    @Override
    public void defaultMethod() {
        System.out.println("override default method");
    }
}

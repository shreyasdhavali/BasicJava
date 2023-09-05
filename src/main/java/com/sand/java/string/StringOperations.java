package com.sand.java.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringOperations {

    public static void main(String[] args) {
        int size = 10;
        String s = "#";
        for (int i =1; i<=size; i++) {
            System.out.println(
                    IntStream.range(0, size-i).mapToObj(x -> " ").collect(Collectors.joining()) +
                            IntStream.range(size - i, size).mapToObj(x -> "#").collect(Collectors.joining())
            );
        }

        // reverse a string
        String reverse = "Shreyas";
        for (int i=reverse.length()-1; i>=0; i--) {
            System.out.print(reverse.toCharArray()[i]);
        }
        System.out.println();
        // swap 2 numbers without temp
        int a =10, b=20;
        b = b + a; // now b is sum of both the numbers b = 30
        a = b - a; // b - a = (b + a) - a = b (a is swapped) a = 20 swapped
        b = b - a; // (b + a) - b = a (b is swapped) b = 10
        System.out.println(a + " " + b);

        // vowel is present in string
        System.out.println("Hello".toLowerCase().matches(".*[aeiou].*"));
        System.out.println("TV".toLowerCase().matches(".*[aeiou].*"));

        //remove spaces from string
        System.out.println("   Shreyas Dhavali  ".trim());
        //reverse String
        System.out.println(new StringBuilder("Hello, World!").reverse());
        //remove other characters
        System.out.println("Hello, %$#^&(World)*&%$".replaceAll("[^a-zA-Z\\s,]", ""));
        // padding add spaces
        System.out.println(String.format("%10s", "42").replace(' ', '0') );

        //count occurances of a charator of substring
        String text = "Hello, world!";
        int countL = text.length() - text.replace("l", "").length();
        int countHello = (text.length() - text.replace("Hello", "").length()) / "Hello".length();
        System.out.println(countL + " " + countHello);
    }
}

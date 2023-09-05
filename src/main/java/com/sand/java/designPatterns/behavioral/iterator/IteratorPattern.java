package com.sand.java.designPatterns.behavioral.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorPattern {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,7,4,2,6,9,3,6,8);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

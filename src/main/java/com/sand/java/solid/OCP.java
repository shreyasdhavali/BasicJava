package com.sand.java.solid;

abstract class OCP {
    abstract double calculateArea();
}

class Circle extends OCP {
    @Override
    double calculateArea() {
        return 0;
    }
    // ...
}

class Square extends OCP {
    @Override
    double calculateArea() {
        return 0;
    }
    // ...
}

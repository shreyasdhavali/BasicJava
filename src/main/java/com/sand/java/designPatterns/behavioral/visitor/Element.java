package com.sand.java.designPatterns.behavioral.visitor;

interface Element {
    void accept(Visitor visitor);
}

package com.sand.java.designPatterns.behavioral.visitor;

interface Visitor {
    void visitConcreteElementA(ConcreteElementA elementA);
    void visitConcreteElementB(ConcreteElementB elementB);
}

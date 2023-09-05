package com.sand.java.designPatterns.behavioral.visitor;

class ConcreteVisitor implements Visitor {
    public void visitConcreteElementA(ConcreteElementA elementA) {
        System.out.println("Visitor is working with " + elementA.operationA());
    }

    public void visitConcreteElementB(ConcreteElementB elementB) {
        System.out.println("Visitor is working with " + elementB.operationB());
    }
}


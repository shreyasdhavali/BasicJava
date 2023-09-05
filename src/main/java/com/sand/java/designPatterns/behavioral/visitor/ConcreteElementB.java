package com.sand.java.designPatterns.behavioral.visitor;

class ConcreteElementB implements Element {
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementB(this);
    }

    String operationB() {
        return "ConcreteElementB";
    }
}

package com.sand.java.designPatterns.behavioral.visitor;

class ConcreteElementA implements Element {
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }

    String operationA() {
        return "ConcreteElementA";
    }
}



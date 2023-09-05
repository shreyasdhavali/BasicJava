package com.sand.java.designPatterns.behavioral.mediator;

public class MediatorPattern {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        mediator.setColleagueA(new Colleague(mediator));
        mediator.setColleagueB(new Colleague(mediator));
        mediator.send("Hello B", new Colleague(mediator));
    }
}

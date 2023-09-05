package com.sand.java.designPatterns.behavioral.observer;

public class ObserverPattern {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observerA = new ConcreteObserverA();
        Observer observerB = new ConcreteObserverB();

        subject.registerObserver(observerA);
        subject.registerObserver(observerB);

        subject.setState("State 1");

        subject.removeObserver(observerB);

        subject.setState("State 2");
    }
}


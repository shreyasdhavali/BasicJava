package com.sand.java.designPatterns.behavioral.observer;

class ConcreteObserverA implements Observer {
    public void update(String message) {
        System.out.println("Observer A received update: " + message);
    }
}




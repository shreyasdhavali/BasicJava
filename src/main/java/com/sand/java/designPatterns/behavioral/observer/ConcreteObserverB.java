package com.sand.java.designPatterns.behavioral.observer;

class ConcreteObserverB implements Observer {
    public void update(String message) {
        System.out.println("Observer B received update: " + message);
    }
}



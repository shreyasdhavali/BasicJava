package com.sand.java.designPatterns.behavioral.observer;

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}


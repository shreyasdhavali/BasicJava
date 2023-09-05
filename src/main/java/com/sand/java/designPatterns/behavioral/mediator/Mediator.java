package com.sand.java.designPatterns.behavioral.mediator;

public interface Mediator {
    void send(String message, Colleague colleague);
}

package com.sand.java.designPatterns.structural.proxy;

public class ServiceProxy implements Service {
    Service service;
    ServiceProxy() {
        this.service = new ActualService();
    }

    @Override
    public void operation() {
        System.out.println("Going via proxy");
        service.operation();
    }
}

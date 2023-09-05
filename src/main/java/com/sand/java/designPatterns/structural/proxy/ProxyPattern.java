package com.sand.java.designPatterns.structural.proxy;

public class ProxyPattern {
    public static void main(String[] args) {
        Service service = new ServiceProxy();
        service.operation();
    }
}

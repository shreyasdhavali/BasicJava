package com.sand.java.solid;

public class DInversionP {
}

// Violation: High-level module depends on low-level module



// Fix: Use dependency injection to invert the dependency
interface Switchable {
    void turnOn();
}

class LightBulb implements Switchable {
    @Override
    public void turnOn() {

    }
    // ...
}

class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    void operate() {
        device.turnOn();
    }
}


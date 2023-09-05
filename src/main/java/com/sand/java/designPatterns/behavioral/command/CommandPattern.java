package com.sand.java.designPatterns.behavioral.command;

public class CommandPattern {

    public static void main(String[] args) {
        Light light = new Light();
        Command on = new TurnOnCommand(light);
        Command off = new TurnOffCommand(light);

        RemoteControl control = new RemoteControl();
        control.setCommand(on);
        control.pressButton();
        control.setCommand(off);
        control.pressButton();
    }
}

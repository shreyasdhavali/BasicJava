package com.sand.java.designPatterns.behavioral.state;

class StateB implements State {
    public void doAction(Context context) {
        System.out.println("State B: Performing action B");
        context.setState(new StateA());
    }
}

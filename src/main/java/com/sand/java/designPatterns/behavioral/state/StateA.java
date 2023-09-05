package com.sand.java.designPatterns.behavioral.state;

class StateA implements State {
    public void doAction(Context context) {
        System.out.println("State A: Performing action A");
        context.setState(new StateB());
    }
}



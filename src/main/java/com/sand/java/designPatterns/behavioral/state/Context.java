package com.sand.java.designPatterns.behavioral.state;

class Context {
    private State state;

    public Context() {
        state = new StateA();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void doAction() {
        state.doAction(this);
    }
}


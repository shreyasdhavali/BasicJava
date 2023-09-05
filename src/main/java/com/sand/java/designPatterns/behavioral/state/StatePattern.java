package com.sand.java.designPatterns.behavioral.state;

public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context();

        context.doAction(); // Output: State A: Performing action A
        context.doAction(); // Output: State B: Performing action B
        context.doAction(); // Output: State A: Performing action A
    }
}


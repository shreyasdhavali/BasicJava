package com.sand.java.features;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornExample {

    public static void main(String[] args) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        // Evaluating a JavaScript expression
        Object result = engine.eval("2 + 3");
        System.out.println("Result: " + result); // Prints "Result: 5"
    }
}


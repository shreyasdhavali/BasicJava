package com.sand.java.features;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornInvokeExample {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        engine.eval("function greet(name) { return 'Hello, ' + name; }");

        Invocable invocable = (Invocable) engine;
        String greeting = (String) invocable.invokeFunction("greet", "Alice");
        System.out.println(greeting); // Prints "Hello, Alice"
    }
}


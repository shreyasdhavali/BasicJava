package com.sand.java.features;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornAccessJava {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        engine.eval("var ArrayList = Java.type('java.util.ArrayList');");
        engine.eval("var list = new ArrayList();");

        Invocable invocable = (Invocable) engine;
        invocable.invokeMethod(engine.get("list"), "add", "Item 1");
        invocable.invokeMethod(engine.get("list"), "add", "Item 2");

        Object result = engine.eval("list.toString();");
        System.out.println(result); // Prints "[Item 1, Item 2]"
    }
}

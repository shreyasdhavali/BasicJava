package com.sand.java.features;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornLibraryExample {

    public static void main(String[] args) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        // Load a JavaScript library
        engine.eval("load('path/to/underscore.js');");

        // Use the library
        engine.eval("var array = [1, 2, 3];");
        Object result = engine.eval("_.map(array, function(num) { return num * 2; });");
        System.out.println(result); // Prints "[2, 4, 6]"
    }
}

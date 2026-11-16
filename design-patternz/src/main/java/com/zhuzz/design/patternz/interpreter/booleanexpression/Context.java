package com.zhuzz.design.patternz.interpreter.booleanexpression;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文：保存变量名与布尔值
 * Context: variable name to boolean value
 */
public class Context {
    private final Map<String, Boolean> variables = new HashMap<>();

    public void assign(String name, boolean value) {
        variables.put(name, value);
    }

    public boolean lookup(String name) {
        return variables.get(name);
    }
}
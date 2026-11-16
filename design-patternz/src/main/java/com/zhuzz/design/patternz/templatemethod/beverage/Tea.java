package com.zhuzz.design.patternz.templatemethod.beverage;

/**
 * 具体类：茶
 * Concrete class: tea
 */
public class Tea extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}
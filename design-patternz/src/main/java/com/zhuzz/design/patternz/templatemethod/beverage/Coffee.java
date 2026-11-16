package com.zhuzz.design.patternz.templatemethod.beverage;

/**
 * 具体类：咖啡
 * Concrete class: coffee
 */
public class Coffee extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}
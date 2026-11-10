package com.zhuzz.design.patternz.decorator.coffeetopping;

/** 具体组件：基础咖啡 */
public class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        return 2.0;
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}
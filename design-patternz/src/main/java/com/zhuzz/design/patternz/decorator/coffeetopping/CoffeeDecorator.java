package com.zhuzz.design.patternz.decorator.coffeetopping;

/** 抽象装饰者：持有被装饰的咖啡，默认转发调用 | Abstract decorator: wraps coffee, forwards by default */
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }

    @Override
    public String description() {
        return decoratedCoffee.description();
    }
}
package com.zhuzz.design.patternz.decorator.coffeetopping;

/** 具体装饰者：加糖 | Concrete decorator: adds sugar */
public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }

    @Override
    public String description() {
        return super.description() + ", with Sugar";
    }
}
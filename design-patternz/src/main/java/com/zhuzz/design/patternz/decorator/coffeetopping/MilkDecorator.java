package com.zhuzz.design.patternz.decorator.coffeetopping;

/** 具体装饰者：加牛奶 */
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost() + 1.0;
    }

    @Override
    public String description() {
        return super.description() + ", with Milk";
    }
}
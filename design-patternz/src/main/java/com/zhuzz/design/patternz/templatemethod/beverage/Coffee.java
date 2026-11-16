package com.zhuzz.design.patternz.templatemethod.beverage;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体类：咖啡
 * Concrete class: coffee
 */
public class Coffee extends Beverage {

    @Override
    protected void brew() {
        Messages.println("beverage.drippingCoffee");
    }

    @Override
    protected void addCondiments() {
        Messages.println("beverage.addingSugarMilk");
    }
}
package com.zhuzz.design.patternz.factorymethod.shapefactory;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体产品：圆形
 * Concrete product: circle
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        Messages.println("shape.circle");
    }
}
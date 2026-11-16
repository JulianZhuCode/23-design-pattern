package com.zhuzz.design.patternz.factorymethod.shapefactory;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体产品：矩形
 * Concrete product: rectangle
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        Messages.println("shape.rectangle");
    }
}
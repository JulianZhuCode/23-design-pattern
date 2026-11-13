package com.zhuzz.design.patternz.factorymethod.shapefactory;

/**
 * 具体产品：矩形
 * Concrete product: rectangle
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}
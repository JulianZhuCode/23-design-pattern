package com.zhuzz.design.patternz.factorymethod.shapefactory;

/** 具体产品：圆形 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}
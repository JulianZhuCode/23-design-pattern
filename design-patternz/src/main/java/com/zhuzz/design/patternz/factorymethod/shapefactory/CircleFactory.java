package com.zhuzz.design.patternz.factorymethod.shapefactory;

/**
 * 具体工厂：创建圆形
 * Concrete factory: creates circles
 */
public class CircleFactory extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}
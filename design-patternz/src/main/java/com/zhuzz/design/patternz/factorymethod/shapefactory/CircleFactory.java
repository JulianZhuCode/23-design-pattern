package com.zhuzz.design.patternz.factorymethod.shapefactory;

/** 具体工厂：创建圆形 */
public class CircleFactory extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}
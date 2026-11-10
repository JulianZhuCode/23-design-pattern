package com.zhuzz.design.patternz.factorymethod.shapefactory;

/** 具体工厂：创建矩形 */
public class RectangleFactory extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}
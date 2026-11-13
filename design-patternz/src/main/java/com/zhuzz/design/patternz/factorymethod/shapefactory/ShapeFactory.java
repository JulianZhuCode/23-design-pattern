package com.zhuzz.design.patternz.factorymethod.shapefactory;

/**
 * 抽象工厂：声明工厂方法，由子类决定创建哪种图形
 * Abstract factory: declares the factory method
 */
public abstract class ShapeFactory {
    public abstract Shape createShape();
}
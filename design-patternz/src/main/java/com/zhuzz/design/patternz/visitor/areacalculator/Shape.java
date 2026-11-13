package com.zhuzz.design.patternz.visitor.areacalculator;

/**
 * 元素接口：接受访问者
 * Element: accepts a visitor
 */
public interface Shape {
    void accept(ShapeVisitor visitor);
}
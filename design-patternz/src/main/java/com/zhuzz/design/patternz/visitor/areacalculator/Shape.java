package com.zhuzz.design.patternz.visitor.areacalculator;

/** 元素接口：接受访问者 */
public interface Shape {
    void accept(ShapeVisitor visitor);
}
package com.zhuzz.design.patternz.visitor.areacalculator;

/** 访问者接口：为每种具体元素声明访问方法 */
public interface ShapeVisitor {
    void visit(Circle circle);

    void visit(Rectangle rectangle);
}
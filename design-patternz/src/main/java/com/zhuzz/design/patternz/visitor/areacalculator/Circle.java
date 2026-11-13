package com.zhuzz.design.patternz.visitor.areacalculator;

/**
 * 具体元素：圆形
 * Concrete element: circle
 */
public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}
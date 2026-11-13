package com.zhuzz.design.patternz.visitor.areacalculator;

/**
 * 具体访问者：计算图形总面积
 * Concrete visitor: computes total area
 */
public class AreaCalculator implements ShapeVisitor {
    private double area;

    @Override
    public void visit(Circle circle) {
        area += Math.PI * circle.getRadius() * circle.getRadius();
    }

    @Override
    public void visit(Rectangle rectangle) {
        area += rectangle.getWidth() * rectangle.getHeight();
    }

    public double getArea() {
        return area;
    }
}
package com.zhuzz.design.patternz.visitor;

/**
 * 访问者模式 - 面积计算案例
 *
 * @author zhuzz
 * 2023/8/29 17:59
 */
public class AreaCalculatorCase {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);

        AreaCalculator areaCalculator = new AreaCalculator();
        circle.accept(areaCalculator);
        rectangle.accept(areaCalculator);

        System.out.println("Total area: " + areaCalculator.getArea());
    }

    interface Shape {
        void accept(ShapeVisitor visitor);
    }


    static class Circle implements Shape {
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

    static class Rectangle implements Shape {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }

        @Override
        public void accept(ShapeVisitor visitor) {
            visitor.visit(this);
        }
    }

    interface ShapeVisitor {
        void visit(Circle circle);

        void visit(Rectangle rectangle);
    }

    static class AreaCalculator implements ShapeVisitor {
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
}
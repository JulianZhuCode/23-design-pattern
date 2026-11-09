package com.zhuzz.design.patternz.bridge;

/**
 * 桥接模式 - 形状颜色案例
 *
 * @author zhuzz
 * 2023/8/29 17:36
 */
public class ShapeColorCase {

    public static void main(String[] args) {
        Color redColor = new Red();
        Color blueColor = new Blue();

        Shape redCircle = new Circle(redColor);
        Shape blueSquare = new Square(blueColor);

        redCircle.draw();
        blueSquare.draw();
    }

    interface Color {
        void applyColor();
    }

    static class Red implements Color {
        public void applyColor() {
            System.out.println("Applying red color");
        }
    }

    static class Blue implements Color {
        public void applyColor() {
            System.out.println("Applying blue color");
        }
    }

    static abstract class Shape {
        protected Color color;

        public Shape(Color color) {
            this.color = color;
        }

        abstract void draw();
    }

    static class Circle extends Shape {
        public Circle(Color color) {
            super(color);
        }

        public void draw() {
            System.out.print("Drawing a circle. ");
            color.applyColor();
        }
    }

    static class Square extends Shape {
        public Square(Color color) {
            super(color);
        }

        public void draw() {
            System.out.print("Drawing a square. ");
            color.applyColor();
        }
    }

}
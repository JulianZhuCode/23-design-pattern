package com.zhuzz.design.patternz.bridge.shapecolor;

/** 扩展抽象化：圆形 | Refined abstraction: circle */
public class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Drawing a circle. ");
        color.applyColor();
    }
}
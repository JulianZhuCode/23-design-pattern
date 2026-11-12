package com.zhuzz.design.patternz.bridge.shapecolor;

/** 扩展抽象化：正方形 | Refined abstraction: square */
public class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Drawing a square. ");
        color.applyColor();
    }
}
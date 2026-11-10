package com.zhuzz.design.patternz.flyweight.circlepool;

/** 具体享元：圆形，颜色是共享的内部状态 */
public class Circle implements Shape {
    private final Color color;

    public Circle(Color color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing a " + color + " circle at (" + x + "," + y + ")");
    }
}
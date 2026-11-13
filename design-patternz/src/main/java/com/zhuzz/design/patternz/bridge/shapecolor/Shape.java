package com.zhuzz.design.patternz.bridge.shapecolor;

/**
 * 抽象化角色：形状，持有颜色实现
 * Abstraction: shape holding a color
 */
public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}
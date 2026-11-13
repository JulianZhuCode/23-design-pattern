package com.zhuzz.design.patternz.flyweight.circlepool;

/**
 * 享元接口：图形，绘制时传入外部坐标
 * Flyweight: shape drawn with external coordinates
 */
public interface Shape {
    void draw(int x, int y);
}
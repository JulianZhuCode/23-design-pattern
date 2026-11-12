package com.zhuzz.design.patternz.adapter.rectangleadapter;

/** 目标接口：客户端期望的绘制接口 | Target: drawing interface expected by client */
public interface Shape {
    void draw(int x, int y, int width, int height);
}
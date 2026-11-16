package com.zhuzz.design.patternz.adapter.rectangleadapter;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 适配者（旧类）：以两点坐标绘制矩形
 * Adaptee: draws via two points
 */
public class LegacyRectangle {
    public void display(int x1, int y1, int x2, int y2) {
        Messages.println("legacyRectangle.display", x1, y1, x2, y2);
    }
}
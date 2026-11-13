package com.zhuzz.design.patternz.bridge.shapecolor;

/**
 * 具体实现：红色
 * Concrete implementor: red
 */
public class Red implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying red color");
    }
}
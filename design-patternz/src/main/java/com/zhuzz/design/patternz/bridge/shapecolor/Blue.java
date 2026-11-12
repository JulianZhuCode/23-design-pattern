package com.zhuzz.design.patternz.bridge.shapecolor;

/** 具体实现：蓝色 | Concrete implementor: blue */
public class Blue implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying blue color");
    }
}
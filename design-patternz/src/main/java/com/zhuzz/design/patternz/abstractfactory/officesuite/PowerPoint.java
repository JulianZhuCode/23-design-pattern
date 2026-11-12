package com.zhuzz.design.patternz.abstractfactory.officesuite;

/** Windows 产品：Microsoft PowerPoint | Windows product: PowerPoint */
public class PowerPoint implements Presentation {
    @Override
    public void showSlides() {
        System.out.println("Showing slides with Microsoft PowerPoint");
    }
}
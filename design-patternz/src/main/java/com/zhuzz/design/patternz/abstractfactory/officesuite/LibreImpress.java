package com.zhuzz.design.patternz.abstractfactory.officesuite;

/** Linux 产品族：LibreOffice Impress */
public class LibreImpress implements Presentation {
    @Override
    public void showSlides() {
        System.out.println("Showing slides with LibreOffice Impress");
    }
}
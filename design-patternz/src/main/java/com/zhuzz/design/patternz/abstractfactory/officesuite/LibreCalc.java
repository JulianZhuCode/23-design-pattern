package com.zhuzz.design.patternz.abstractfactory.officesuite;

/** Linux 产品族：LibreOffice Calc */
public class LibreCalc implements Spreadsheet {
    @Override
    public void calculate() {
        System.out.println("Calculating with LibreOffice Calc");
    }
}
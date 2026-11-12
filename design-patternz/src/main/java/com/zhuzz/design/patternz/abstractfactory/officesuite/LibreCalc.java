package com.zhuzz.design.patternz.abstractfactory.officesuite;

/** Linux 产品：LibreOffice Calc | Linux product: Calc */
public class LibreCalc implements Spreadsheet {
    @Override
    public void calculate() {
        System.out.println("Calculating with LibreOffice Calc");
    }
}
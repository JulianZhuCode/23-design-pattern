package com.zhuzz.design.patternz.abstractfactory.officesuite;

/**
 * Windows 产品：Microsoft Excel
 * Windows product: Excel
 */
public class Excel implements Spreadsheet {
    @Override
    public void calculate() {
        System.out.println("Calculating with Microsoft Excel");
    }
}
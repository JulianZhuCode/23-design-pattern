package com.zhuzz.design.patternz.abstractfactory.officesuite;

/** Windows 产品族：Microsoft Excel */
public class Excel implements Spreadsheet {
    @Override
    public void calculate() {
        System.out.println("Calculating with Microsoft Excel");
    }
}
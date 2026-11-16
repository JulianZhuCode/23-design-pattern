package com.zhuzz.design.patternz.abstractfactory.officesuite;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * Windows 产品：Microsoft Excel
 * Windows product: Excel
 */
public class Excel implements Spreadsheet {
    @Override
    public void calculate() {
        Messages.println("excel.calculate");
    }
}
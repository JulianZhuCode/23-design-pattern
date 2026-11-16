package com.zhuzz.design.patternz.abstractfactory.officesuite;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * Linux 产品：LibreOffice Calc
 * Linux product: Calc
 */
public class LibreCalc implements Spreadsheet {
    @Override
    public void calculate() {
        Messages.println("calc.calculate");
    }
}
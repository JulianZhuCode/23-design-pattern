package com.zhuzz.design.patternz.abstractfactory.officesuite;

/** Windows 产品：Microsoft Word | Windows product: Word */
public class Word implements WordProcessor {
    @Override
    public void editDocument() {
        System.out.println("Editing document with Microsoft Word");
    }
}
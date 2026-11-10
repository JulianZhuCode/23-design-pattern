package com.zhuzz.design.patternz.abstractfactory.officesuite;

/** Linux 产品族：LibreOffice Writer */
public class LibreWriter implements WordProcessor {
    @Override
    public void editDocument() {
        System.out.println("Editing document with LibreOffice Writer");
    }
}
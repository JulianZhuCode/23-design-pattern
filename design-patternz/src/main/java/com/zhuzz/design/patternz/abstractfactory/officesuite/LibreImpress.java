package com.zhuzz.design.patternz.abstractfactory.officesuite;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * Linux 产品：LibreOffice Impress
 * Linux product: Impress
 */
public class LibreImpress implements Presentation {
    @Override
    public void showSlides() {
        Messages.println("impress.show");
    }
}
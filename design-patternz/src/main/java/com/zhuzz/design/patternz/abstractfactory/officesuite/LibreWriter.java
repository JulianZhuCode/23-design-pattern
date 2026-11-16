package com.zhuzz.design.patternz.abstractfactory.officesuite;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * Linux 产品：LibreOffice Writer
 * Linux product: Writer
 */
public class LibreWriter implements WordProcessor {
    @Override
    public void editDocument() {
        Messages.println("writer.edit");
    }
}
package com.zhuzz.design.patternz.abstractfactory.officesuite;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * Windows 产品：Microsoft Word
 * Windows product: Word
 */
public class Word implements WordProcessor {
    @Override
    public void editDocument() {
        Messages.println("word.edit");
    }
}
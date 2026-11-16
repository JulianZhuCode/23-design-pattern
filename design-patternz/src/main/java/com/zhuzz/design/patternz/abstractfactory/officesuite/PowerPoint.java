package com.zhuzz.design.patternz.abstractfactory.officesuite;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * Windows 产品：Microsoft PowerPoint
 * Windows product: PowerPoint
 */
public class PowerPoint implements Presentation {
    @Override
    public void showSlides() {
        Messages.println("powerpoint.show");
    }
}
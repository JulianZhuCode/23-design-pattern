package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

/** Mac 具体工厂：产出整套 Mac 风格组件 */
public class MacFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextField createTextField() {
        return new MacTextField();
    }
}
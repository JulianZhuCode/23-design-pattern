package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

/**
 * Windows 具体工厂：产出整套 Windows 组件
 * Concrete factory: Windows widgets
 */
public class WindowsFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }
}
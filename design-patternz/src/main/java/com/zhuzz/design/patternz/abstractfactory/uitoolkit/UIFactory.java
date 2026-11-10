package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

/** 抽象工厂：UI 组件工厂，创建一整套相关组件 */
public interface UIFactory {
    Button createButton();

    TextField createTextField();
}
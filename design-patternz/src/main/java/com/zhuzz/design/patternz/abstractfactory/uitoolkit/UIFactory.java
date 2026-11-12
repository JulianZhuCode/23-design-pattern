package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

/** 抽象工厂：创建一整套相关 UI 组件 | Abstract factory: creates related UI widgets */
public interface UIFactory {
    Button createButton();

    TextField createTextField();
}
package com.zhuzz.design.patternz.observer.numberobserver;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体观察者：接收更新并输出
 * Concrete observer: prints updates
 */
public class ConcreteObserver implements Observer {
    private final String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int state) {
        Messages.println("observer.update", name, state);
    }
}
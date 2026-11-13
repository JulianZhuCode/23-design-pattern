package com.zhuzz.design.patternz.observer.numberobserver;

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
        System.out.println(name + " 收到更新，新状态为: " + state);
    }
}
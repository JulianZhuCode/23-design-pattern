package com.zhuzz.design.patternz.observer.numberobserver;

/** 主题接口：声明观察者的增删与通知方法 | Subject: register/remove/notify observers */
public interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
package com.zhuzz.design.patternz.observer.numberobserver;

/** 观察者接口：接收主题状态更新 */
public interface Observer {
    void update(int state);
}
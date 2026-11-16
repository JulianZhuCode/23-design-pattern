package com.zhuzz.design.patternz.observer.weather;

/**
 * 主题接口：声明观察者的增删与通知方法
 * Subject: register/remove/notify observers
 */
public interface WeatherSubject {
    void addObserver(WeatherObserver observer);

    void removeObserver(WeatherObserver observer);

    void notifyObservers();
}
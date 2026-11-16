package com.zhuzz.design.patternz.observer.weather;

/**
 * 观察者接口：接收天气数据更新
 * Observer: receives weather updates
 */
public interface WeatherObserver {
    void update(float temperature, float humidity);
}
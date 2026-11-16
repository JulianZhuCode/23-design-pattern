package com.zhuzz.design.patternz.observer.weather;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 具体主题：气象站，测量数据变化时通知所有观察者
 * Concrete subject: weather station notifying observers
 */
public class WeatherStation implements WeatherSubject {
    private final List<WeatherObserver> observers = new CopyOnWriteArrayList<>();
    private float temperature;
    private float humidity;

    public void setMeasurements(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }

    @Override
    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature, humidity);
        }
    }
}
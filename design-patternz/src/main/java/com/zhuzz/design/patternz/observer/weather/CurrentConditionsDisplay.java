package com.zhuzz.design.patternz.observer.weather;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体观察者：当前天气显示
 * Concrete observer: current conditions display
 */
public class CurrentConditionsDisplay implements WeatherObserver {
    private final String name;

    public CurrentConditionsDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature, float humidity) {
        Messages.println("weather.conditions", name, temperature, humidity);
    }
}
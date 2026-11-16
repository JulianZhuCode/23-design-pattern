package com.zhuzz.design.patternz.observer.weather;

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
        System.out.println(name + ": " + temperature + "C, " + humidity + "% humidity");
    }
}
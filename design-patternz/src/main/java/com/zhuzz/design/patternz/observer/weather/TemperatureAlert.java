package com.zhuzz.design.patternz.observer.weather;

/**
 * 具体观察者：高温预警，超过阈值时提醒
 * Concrete observer: high-temperature alert
 */
public class TemperatureAlert implements WeatherObserver {
    private final float threshold;

    public TemperatureAlert(float threshold) {
        this.threshold = threshold;
    }

    @Override
    public void update(float temperature, float humidity) {
        if (temperature > threshold) {
            System.out.println("Alert: " + temperature + "C exceeds " + threshold + "C");
        }
    }
}
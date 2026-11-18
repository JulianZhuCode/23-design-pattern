package com.zhuzz.design.patternz.observer.weather;

import com.zhuzz.design.lab.DemoSupport;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.i18n.Messages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class WeatherDemo extends DemoSupport {
    @Override public I18nMessages pattern() { return PAT_OBSERVER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Weather Station", Locale.SIMPLIFIED_CHINESE, "气象站");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(new PlaygroundInput(
                "temperature",
                Map.of(Locale.ENGLISH, "Temperature", Locale.SIMPLIFIED_CHINESE, "温度"),
                PlaygroundInput.Type.TEXT,
                List.of(),
                "25"));
    }

    @Override public void run(Map<String, String> values) {
        WeatherStation station = new WeatherStation();

        CurrentConditionsDisplay display = new CurrentConditionsDisplay("Display");
        TemperatureAlert alert = new TemperatureAlert(35);

        station.addObserver(display);
        station.addObserver(alert);

        // 按用户输入的温度发布一次测量，观察观察者如何响应
        // publish one measurement at the user-provided temperature to see observers react
        int temperature;
        try {
            temperature = Integer.parseInt(values.getOrDefault("temperature", "25"));
        } catch (NumberFormatException e) {
            Messages.println("weather.invalidTemperature");
            return;
        }
        station.setMeasurements(temperature, 60);
    }
}
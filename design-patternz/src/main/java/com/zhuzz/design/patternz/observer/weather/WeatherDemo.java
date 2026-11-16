package com.zhuzz.design.patternz.observer.weather;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class WeatherDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_OBSERVER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Weather Station", Locale.SIMPLIFIED_CHINESE, "气象站");
    }
    @Override public void run() {
        WeatherStation station = new WeatherStation();

        CurrentConditionsDisplay display = new CurrentConditionsDisplay("Display");
        TemperatureAlert alert = new TemperatureAlert(35);

        station.addObserver(display);
        station.addObserver(alert);

        station.setMeasurements(25, 60);
        station.setMeasurements(38, 40);
    }
}
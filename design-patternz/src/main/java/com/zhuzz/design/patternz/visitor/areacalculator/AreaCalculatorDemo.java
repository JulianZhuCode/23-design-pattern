package com.zhuzz.design.patternz.visitor.areacalculator;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class AreaCalculatorDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_VISITOR; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Area Calculator", Locale.SIMPLIFIED_CHINESE, "面积计算");
    }
    @Override public void run() {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);

        AreaCalculator areaCalculator = new AreaCalculator();
        circle.accept(areaCalculator);
        rectangle.accept(areaCalculator);

        System.out.println("Total area: " + areaCalculator.getArea());
    }
}
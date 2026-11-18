package com.zhuzz.design.patternz.visitor.areacalculator;

import com.zhuzz.design.lab.DemoSupport;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.i18n.Messages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 访问者模式演示：计算图形总面积
 * Visitor demo: computes total shape area
 */
public class AreaCalculatorDemo extends DemoSupport {
    @Override public I18nMessages pattern() { return PAT_VISITOR; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Area Calculator", Locale.SIMPLIFIED_CHINESE, "面积计算");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);

        AreaCalculator areaCalculator = new AreaCalculator();
        circle.accept(areaCalculator);
        rectangle.accept(areaCalculator);

        Messages.println("area.total", areaCalculator.getArea());
    }
}
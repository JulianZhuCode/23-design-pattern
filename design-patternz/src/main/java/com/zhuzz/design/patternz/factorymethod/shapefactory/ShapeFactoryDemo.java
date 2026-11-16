package com.zhuzz.design.patternz.factorymethod.shapefactory;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ShapeFactoryDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_FACTORY_METHOD; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Shape Factory", Locale.SIMPLIFIED_CHINESE, "图形工厂");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(new PlaygroundInput(
                "shape",
                Map.of(Locale.ENGLISH, "Shape", Locale.SIMPLIFIED_CHINESE, "图形"),
                PlaygroundInput.Type.CHOICE,
                List.of("Circle", "Rectangle"),
                "Circle"));
    }

    @Override public void run(Map<String, String> values) {
        // 按用户选择的图形创建对应工厂，再产出图形并绘制
        // create a factory for the user-selected shape, then produce and draw it
        String shape = values.getOrDefault("shape", "Circle");
        ShapeFactory factory = new CircleFactory();
        if ("Rectangle".equals(shape)) {
            factory = new RectangleFactory();
        }
        Shape result = factory.createShape();
        result.draw();
    }
}
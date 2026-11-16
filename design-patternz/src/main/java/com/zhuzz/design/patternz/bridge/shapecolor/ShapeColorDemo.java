package com.zhuzz.design.patternz.bridge.shapecolor;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ShapeColorDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_BRIDGE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Shape & Color", Locale.SIMPLIFIED_CHINESE, "图形着色");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(
                new PlaygroundInput(
                        "shape",
                        Map.of(Locale.ENGLISH, "Shape", Locale.SIMPLIFIED_CHINESE, "图形"),
                        PlaygroundInput.Type.CHOICE,
                        List.of("Circle", "Square"),
                        "Circle"),
                new PlaygroundInput(
                        "color",
                        Map.of(Locale.ENGLISH, "Color", Locale.SIMPLIFIED_CHINESE, "颜色"),
                        PlaygroundInput.Type.CHOICE,
                        List.of("Red", "Blue"),
                        "Red"));
    }

    @Override public void run(Map<String, String> values) {
        // 按用户选择的图形与颜色组合，观察桥接如何解耦两个维度
        // combine the user-selected shape and color to see how the bridge decouples them
        String shapeVal = values.getOrDefault("shape", "Circle");
        String colorVal = values.getOrDefault("color", "Red");
        Color color = "Blue".equals(colorVal) ? new Blue() : new Red();
        Shape shape = "Square".equals(shapeVal) ? new Square(color) : new Circle(color);
        shape.draw();
    }
}
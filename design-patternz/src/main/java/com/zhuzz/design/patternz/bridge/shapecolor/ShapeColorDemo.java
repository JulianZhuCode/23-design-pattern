package com.zhuzz.design.patternz.bridge.shapecolor;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ShapeColorDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_BRIDGE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Shape & Color", Locale.SIMPLIFIED_CHINESE, "图形着色");
    }
    @Override public void run() {
        Color redColor = new Red();
        Color blueColor = new Blue();

        Shape redCircle = new Circle(redColor);
        Shape blueSquare = new Square(blueColor);

        redCircle.draw();
        blueSquare.draw();
    }
}
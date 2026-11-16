package com.zhuzz.design.patternz.adapter.rectangleadapter;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class RectangleAdapterDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_ADAPTER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Rectangle Adapter", Locale.SIMPLIFIED_CHINESE, "矩形适配");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        LegacyRectangle legacyRectangle = new LegacyRectangle();
        Shape shapeAdapter = new RectangleAdapter(legacyRectangle);

        shapeAdapter.draw(10, 20, 50, 30);
    }
}
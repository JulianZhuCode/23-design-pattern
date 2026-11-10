package com.zhuzz.design.patternz.adapter.rectangleadapter;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class RectangleAdapterDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_ADAPTER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Rectangle Adapter", Locale.SIMPLIFIED_CHINESE, "矩形适配");
    }
    @Override public void run() {
        LegacyRectangle legacyRectangle = new LegacyRectangle();
        Shape shapeAdapter = new RectangleAdapter(legacyRectangle);

        shapeAdapter.draw(10, 20, 50, 30);
    }
}
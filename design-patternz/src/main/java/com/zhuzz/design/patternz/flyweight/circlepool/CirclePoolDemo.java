package com.zhuzz.design.patternz.flyweight.circlepool;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 享元模式演示：共享颜色相同的圆形实例
 * Flyweight demo: share circles of the same color
 */
public class CirclePoolDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_FLYWEIGHT; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Circle Pool", Locale.SIMPLIFIED_CHINESE, "圆形共享");
    }
    @Override public void run() {
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

        for (int i = 0; i < 20; i++) {
            Color randomColor = colors[(int) (Math.random() * colors.length)];
            Shape circle = ShapeFactory.getCircle(randomColor);
            circle.draw((int) (Math.random() * 100), (int) (Math.random() * 100));
        }
    }
}
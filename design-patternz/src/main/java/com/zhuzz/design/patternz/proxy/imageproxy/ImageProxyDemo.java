package com.zhuzz.design.patternz.proxy.imageproxy;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ImageProxyDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_PROXY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Lazy Image", Locale.SIMPLIFIED_CHINESE, "图片延迟加载");
    }
    @Override public void run() {
        Image image = new ProxyImage("sample.jpg");

        // 图像未加载，直到调用 display() 方法
        image.display();

        // 图像已加载，无需再次创建
        image.display();
    }
}
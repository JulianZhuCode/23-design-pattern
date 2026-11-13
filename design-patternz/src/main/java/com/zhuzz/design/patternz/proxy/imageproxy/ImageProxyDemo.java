package com.zhuzz.design.patternz.proxy.imageproxy;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 代理模式演示：延迟加载图片
 * Proxy demo: lazy image loading
 */
public class ImageProxyDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_PROXY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Lazy Image", Locale.SIMPLIFIED_CHINESE, "图片延迟加载");
    }
    @Override public void run() {
        Image image = new ProxyImage("sample.jpg");

        // 首次 display() 时才真正加载
        // lazy load on first display()
        image.display();

        // 已加载，不再重复创建
        // already loaded, no re-creation
        image.display();
    }
}
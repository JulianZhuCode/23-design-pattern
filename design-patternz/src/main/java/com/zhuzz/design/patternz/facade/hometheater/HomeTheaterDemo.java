package com.zhuzz.design.patternz.facade.hometheater;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 外观模式演示：一键完成观影准备
 * Facade demo: one-click movie setup
 */
public class HomeTheaterDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_FACADE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Home Theater", Locale.SIMPLIFIED_CHINESE, "家庭影院");
    }
    @Override public void run() {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        // 准备观影
        // prepare to watch
        homeTheater.watchMovie();

        // 结束观影
        // finish watching
        homeTheater.endMovie();
    }
}
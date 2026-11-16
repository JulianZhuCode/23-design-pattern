package com.zhuzz.design.patternz.facade.computerstart;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ComputerStartDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_FACADE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "One-Click Boot", Locale.SIMPLIFIED_CHINESE, "电脑一键开机");
    }
    @Override public void run() {
        ComputerFacade computer = new ComputerFacade();

        // 一键开机
        // one-click boot
        computer.start();

        // 一键关机
        // one-click shutdown
        computer.shutdown();
    }
}
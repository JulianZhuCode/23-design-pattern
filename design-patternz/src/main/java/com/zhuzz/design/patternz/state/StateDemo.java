package com.zhuzz.design.patternz.state;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class StateDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_STATE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Elevator State", Locale.SIMPLIFIED_CHINESE, "电梯状态");
    }
    @Override public void run() { ElevatorCase.main(new String[0]); }
}
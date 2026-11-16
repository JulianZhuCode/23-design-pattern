package com.zhuzz.design.patternz.state.gumball;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class GumballDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_STATE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Gumball Machine", Locale.SIMPLIFIED_CHINESE, "糖果机");
    }
    @Override public void run() {
        GumballMachine machine = new GumballMachine(2);

        machine.insertQuarter();
        machine.turnCrank();

        machine.insertQuarter();
        machine.ejectQuarter();
        machine.insertQuarter();
        machine.turnCrank();

        // 此时糖果已售罄
        // sold out now
        machine.insertQuarter();
    }
}
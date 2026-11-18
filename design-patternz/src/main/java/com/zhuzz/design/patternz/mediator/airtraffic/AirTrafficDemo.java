package com.zhuzz.design.patternz.mediator.airtraffic;

import com.zhuzz.design.lab.DemoSupport;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class AirTrafficDemo extends DemoSupport {
    @Override public I18nMessages pattern() { return PAT_MEDIATOR; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Air Traffic", Locale.SIMPLIFIED_CHINESE, "空中交通");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        ControlTower tower = new ControlTower();

        Airplane flight1 = new Airplane("Flight A", tower);
        Airplane flight2 = new Airplane("Flight B", tower);

        tower.registerPlane(flight1);
        tower.registerPlane(flight2);

        flight1.requestLanding();
        // 跑道被占用，第二架只能等待
        // runway busy, second plane waits
        flight2.requestLanding();
        flight1.requestTakeoff();
        // 跑道空出后第二架方可降落
        // runway freed, second plane lands
        flight2.requestLanding();
    }
}
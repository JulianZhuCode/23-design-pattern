package com.zhuzz.design.patternz.builder.computerbuilder;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ComputerBuilderDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_BUILDER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Computer Builder", Locale.SIMPLIFIED_CHINESE, "电脑组装");
    }
    @Override public void run() {
        // 同一指挥者 + 不同建造者，产出不同配置的电脑
        // Same director + different builders yield different configurations
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        Director gamingDirector = new Director(gamingBuilder);
        Computer gamingComputer = gamingDirector.constructComputer();
        System.out.println("Gaming Computer: " + gamingComputer);

        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        Director officeDirector = new Director(officeBuilder);
        Computer officeComputer = officeDirector.constructComputer();
        System.out.println("Office Computer: " + officeComputer);
    }
}
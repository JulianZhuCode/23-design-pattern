package com.zhuzz.design.patternz.builder.housebuilder;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class HouseBuilderDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_BUILDER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "House Builder", Locale.SIMPLIFIED_CHINESE, "房屋建造");
    }
    @Override public void run() {
        HouseBuilder concreteBuilder = new ConcreteHouseBuilder();
        Director director1 = new Director(concreteBuilder);
        House concreteHouse = director1.constructHouse();
        System.out.println("Concrete House: " + concreteHouse);

        HouseBuilder luxuryBuilder = new LuxuryHouseBuilder();
        Director director2 = new Director(luxuryBuilder);
        House luxuryHouse = director2.constructHouse();
        System.out.println("Luxury House: " + luxuryHouse);
    }
}
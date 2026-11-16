package com.zhuzz.design.patternz.builder.housebuilder;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class HouseBuilderDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_BUILDER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "House Builder", Locale.SIMPLIFIED_CHINESE, "房屋建造");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(new PlaygroundInput(
                "type",
                Map.of(Locale.ENGLISH, "House Type", Locale.SIMPLIFIED_CHINESE, "房屋类型"),
                PlaygroundInput.Type.CHOICE,
                List.of("Concrete", "Luxury"),
                "Concrete"));
    }

    @Override public void run(Map<String, String> values) {
        // 按用户选择的房屋类型选择建造者，交由 Director 组装
        // pick a builder by the user-selected type, then let the Director assemble it
        String type = values.getOrDefault("type", "Concrete");
        HouseBuilder builder = new ConcreteHouseBuilder();
        if ("Luxury".equals(type)) {
            builder = new LuxuryHouseBuilder();
        }
        Director director = new Director(builder);
        House house = director.constructHouse();
        System.out.println(type + " House: " + house);
    }
}
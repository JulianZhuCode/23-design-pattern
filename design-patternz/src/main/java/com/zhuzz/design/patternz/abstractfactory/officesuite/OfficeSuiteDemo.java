package com.zhuzz.design.patternz.abstractfactory.officesuite;

import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.DemoSupport;
import com.zhuzz.design.lab.playground.PlaygroundInput;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.PAT_ABSTRACT_FACTORY;

public class OfficeSuiteDemo extends DemoSupport {

    private static final String PLATFORM = "platform";

    @Override public I18nMessages pattern() { return PAT_ABSTRACT_FACTORY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Office Suite", Locale.SIMPLIFIED_CHINESE, "办公套件");
    }

    @Override public List<PlaygroundInput> inputs() {
        return List.of(new PlaygroundInput(
                PLATFORM,
                Map.of(Locale.ENGLISH, "Platform", Locale.SIMPLIFIED_CHINESE, "平台"),
                PlaygroundInput.Type.CHOICE,
                List.of("Windows", "Linux"),
                "Windows"));
    }

    @Override public void run(Map<String, String> values) {
        String platform = values.getOrDefault(PLATFORM, "Windows");
        OfficeSuiteFactory factory = "Linux".equals(platform) ? new LinuxFactory() : new WindowsFactory();

        WordProcessor word = factory.createWordProcessor();
        Spreadsheet sheet = factory.createSpreadsheet();
        Presentation slides = factory.createPresentation();

        word.editDocument();
        sheet.calculate();
        slides.showSlides();
    }
}
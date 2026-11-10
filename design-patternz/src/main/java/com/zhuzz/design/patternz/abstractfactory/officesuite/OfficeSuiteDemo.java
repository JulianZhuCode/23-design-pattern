package com.zhuzz.design.patternz.abstractfactory.officesuite;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class OfficeSuiteDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_ABSTRACT_FACTORY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Office Suite", Locale.SIMPLIFIED_CHINESE, "办公套件");
    }
    @Override public void run() {
        OfficeSuiteFactory windowsFactory = new WindowsFactory();
        WordProcessor windowsWord = windowsFactory.createWordProcessor();
        Spreadsheet windowsSheet = windowsFactory.createSpreadsheet();
        Presentation windowsSlides = windowsFactory.createPresentation();

        windowsWord.editDocument();
        windowsSheet.calculate();
        windowsSlides.showSlides();

        System.out.println("----------");

        OfficeSuiteFactory linuxFactory = new LinuxFactory();
        WordProcessor linuxWord = linuxFactory.createWordProcessor();
        Spreadsheet linuxSheet = linuxFactory.createSpreadsheet();
        Presentation linuxSlides = linuxFactory.createPresentation();

        linuxWord.editDocument();
        linuxSheet.calculate();
        linuxSlides.showSlides();
    }
}
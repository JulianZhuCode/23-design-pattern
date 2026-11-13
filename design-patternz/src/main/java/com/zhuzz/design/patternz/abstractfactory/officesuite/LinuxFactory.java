package com.zhuzz.design.patternz.abstractfactory.officesuite;

/**
 * Linux 具体工厂：产出整套 Linux 办公套件
 * Concrete factory: Linux suite
 */
public class LinuxFactory implements OfficeSuiteFactory {
    @Override
    public WordProcessor createWordProcessor() {
        return new LibreWriter();
    }

    @Override
    public Spreadsheet createSpreadsheet() {
        return new LibreCalc();
    }

    @Override
    public Presentation createPresentation() {
        return new LibreImpress();
    }
}
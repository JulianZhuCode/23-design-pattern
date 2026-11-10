package com.zhuzz.design.patternz.abstractfactory.officesuite;

/** Windows 具体工厂：产出整套 Windows 办公套件 */
public class WindowsFactory implements OfficeSuiteFactory {
    @Override
    public WordProcessor createWordProcessor() {
        return new Word();
    }

    @Override
    public Spreadsheet createSpreadsheet() {
        return new Excel();
    }

    @Override
    public Presentation createPresentation() {
        return new PowerPoint();
    }
}
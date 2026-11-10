package com.zhuzz.design.patternz.abstractfactory.officesuite;

/** 抽象工厂：办公套件工厂，创建一整套办公软件 */
public interface OfficeSuiteFactory {
    WordProcessor createWordProcessor();

    Spreadsheet createSpreadsheet();

    Presentation createPresentation();
}
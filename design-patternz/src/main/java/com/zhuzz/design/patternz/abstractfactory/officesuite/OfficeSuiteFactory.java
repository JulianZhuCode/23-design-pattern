package com.zhuzz.design.patternz.abstractfactory.officesuite;

/**
 * 抽象工厂：创建一整套办公软件
 * Abstract factory: creates an office suite
 */
public interface OfficeSuiteFactory {
    WordProcessor createWordProcessor();

    Spreadsheet createSpreadsheet();

    Presentation createPresentation();
}
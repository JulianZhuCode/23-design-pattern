package com.zhuzz.design.patternz.builder.computerbuilder;

/**
 * 具体建造者：组装办公电脑
 * Concrete builder: office computer
 */
public class OfficeComputerBuilder extends ComputerBuilder {
    @Override
    public void buildCpu() {
        computer.setCpu("Intel Core i5");
    }

    @Override
    public void buildRam() {
        computer.setRam("16GB DDR4");
    }

    @Override
    public void buildGpu() {
        computer.setGpu("Integrated Graphics");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("512GB SSD");
    }
}
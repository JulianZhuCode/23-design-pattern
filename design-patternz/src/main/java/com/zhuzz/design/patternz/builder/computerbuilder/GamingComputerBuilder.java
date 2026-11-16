package com.zhuzz.design.patternz.builder.computerbuilder;

/**
 * 具体建造者：组装游戏电脑
 * Concrete builder: gaming computer
 */
public class GamingComputerBuilder extends ComputerBuilder {
    @Override
    public void buildCpu() {
        computer.setCpu("Intel Core i9");
    }

    @Override
    public void buildRam() {
        computer.setRam("32GB DDR5");
    }

    @Override
    public void buildGpu() {
        computer.setGpu("NVIDIA RTX 4090");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("2TB NVMe SSD");
    }
}
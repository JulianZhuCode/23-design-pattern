package com.zhuzz.design.patternz.builder.computerbuilder;

/**
 * 指挥者：按固定顺序组装电脑
 * Director: builds in a fixed order
 */
public class Director {
    private ComputerBuilder builder;

    public Director(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer constructComputer() {
        builder.buildCpu();
        builder.buildRam();
        builder.buildGpu();
        builder.buildStorage();
        return builder.getComputer();
    }
}
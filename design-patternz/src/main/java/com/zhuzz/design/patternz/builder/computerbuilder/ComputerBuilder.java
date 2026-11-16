package com.zhuzz.design.patternz.builder.computerbuilder;

/**
 * 抽象建造者：定义组装电脑各部分的步骤
 * Abstract builder: defines build steps
 */
public abstract class ComputerBuilder {
    protected Computer computer = new Computer();

    public abstract void buildCpu();

    public abstract void buildRam();

    public abstract void buildGpu();

    public abstract void buildStorage();

    public Computer getComputer() {
        return computer;
    }
}
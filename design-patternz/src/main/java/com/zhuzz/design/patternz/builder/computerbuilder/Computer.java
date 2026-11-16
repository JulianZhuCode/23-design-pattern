package com.zhuzz.design.patternz.builder.computerbuilder;

/**
 * 产品：电脑，由 CPU、内存、显卡、硬盘构成
 * Product: computer
 */
public class Computer {
    private String cpu;
    private String ram;
    private String gpu;
    private String storage;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Computer [cpu=" + cpu + ", ram=" + ram + ", gpu=" + gpu + ", storage=" + storage + "]";
    }
}
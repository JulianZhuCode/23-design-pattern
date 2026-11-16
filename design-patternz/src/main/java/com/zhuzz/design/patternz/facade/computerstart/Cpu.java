package com.zhuzz.design.patternz.facade.computerstart;

/**
 * 子系统：CPU
 * Subsystem: CPU
 */
public class Cpu {
    public void start() {
        System.out.println("CPU is starting");
    }

    public void shutdown() {
        System.out.println("CPU is shutting down");
    }
}
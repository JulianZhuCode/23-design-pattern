package com.zhuzz.design.patternz.facade.computerstart;

/**
 * 子系统：内存
 * Subsystem: memory
 */
public class Memory {
    public void load() {
        System.out.println("Memory is loading data");
    }

    public void clear() {
        System.out.println("Memory is cleared");
    }
}
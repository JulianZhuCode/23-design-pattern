package com.zhuzz.design.patternz.facade.computerstart;

/**
 * 子系统：硬盘
 * Subsystem: disk
 */
public class Disk {
    public void read() {
        System.out.println("Disk is reading data");
    }

    public void stop() {
        System.out.println("Disk is stopped");
    }
}
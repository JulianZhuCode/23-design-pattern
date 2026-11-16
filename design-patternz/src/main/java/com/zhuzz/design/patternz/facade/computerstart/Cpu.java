package com.zhuzz.design.patternz.facade.computerstart;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 子系统：CPU
 * Subsystem: CPU
 */
public class Cpu {
    public void start() {
        Messages.println("cpu.starting");
    }

    public void shutdown() {
        Messages.println("cpu.shutdown");
    }
}
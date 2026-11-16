package com.zhuzz.design.patternz.facade.computerstart;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 子系统：内存
 * Subsystem: memory
 */
public class Memory {
    public void load() {
        Messages.println("memory.load");
    }

    public void clear() {
        Messages.println("memory.clear");
    }
}
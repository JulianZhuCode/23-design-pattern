package com.zhuzz.design.patternz.facade.computerstart;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 子系统：硬盘
 * Subsystem: disk
 */
public class Disk {
    public void read() {
        Messages.println("disk.read");
    }

    public void stop() {
        Messages.println("disk.stop");
    }
}
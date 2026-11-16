package com.zhuzz.design.patternz.facade.computerstart;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 外观：统一封装开机/关机的多个子系统操作
 * Facade: wraps subsystem operations for boot and shutdown
 */
public class ComputerFacade {
    private Power power;
    private Cpu cpu;
    private Memory memory;
    private Disk disk;

    public ComputerFacade() {
        power = new Power();
        cpu = new Cpu();
        memory = new Memory();
        disk = new Disk();
    }

    public void start() {
        Messages.println("computerFacade.boot");
        power.on();
        cpu.start();
        memory.load();
        disk.read();
    }

    public void shutdown() {
        Messages.println("computerFacade.shutdown");
        disk.stop();
        memory.clear();
        cpu.shutdown();
        power.off();
    }
}